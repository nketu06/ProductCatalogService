package com.example.ProductCatalogService.controllers;

import com.example.ProductCatalogService.dtos.CategoryDto;
import com.example.ProductCatalogService.dtos.ProductDto;
import com.example.ProductCatalogService.models.Category;
import com.example.ProductCatalogService.models.Product;
import com.example.ProductCatalogService.models.State;
import com.example.ProductCatalogService.services.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired private ProductService productService;

  @GetMapping
  public List<Product> getAllProducts() {
    Product product = new Product();
    product.setId(1);
    product.setTitle("iPhone 13");
    product.setDescription("The latest iPhone model with A15 Bionic chip.");
    product.setPrice(999.99);
    product.setState(State.ACTIVE);
    return List.of(product);
  }

  @GetMapping("{id}")
  public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long productId) {
    if (productId <= 0) {
      throw new IllegalArgumentException("Product ID cannot be zero or negative.");
    }
    Product product = productService.getProductById(productId);
    if (product != null) {
      ProductDto productDto = mapProductToProductDto(product);
      return new ResponseEntity<>(productDto, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PostMapping
  public ProductDto createProduct(@RequestBody ProductDto input) {
    return input;
  }

  @PutMapping("{id}")
  public ResponseEntity<ProductDto> replaceProduct(
      @PathVariable("id") Long productId, @RequestBody ProductDto input) {

    Product product = productService.replaceProduct(productId, mapProductDtoToProduct(input));
    if (product != null) {
      ProductDto productDto = mapProductToProductDto(product);
      return new ResponseEntity<>(productDto, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  private ProductDto mapProductToProductDto(Product product) {
    ProductDto productDto = new ProductDto();
    productDto.setId(product.getId());
    productDto.setTitle(product.getTitle());
    productDto.setDescription(product.getDescription());
    productDto.setPrice(product.getPrice());
    CategoryDto categoryDto = new CategoryDto();
    categoryDto.setTitle(product.getCategory().getTitle());
    categoryDto.setDescription(product.getCategory().getDescription());
    categoryDto.setId(product.getCategory().getId());

    productDto.setCategory(categoryDto);
    return productDto;
  }

  private Product mapProductDtoToProduct(ProductDto productDto) {
    Product product = new Product();
    product.setId(productDto.getId());
    product.setTitle(productDto.getTitle());
    product.setDescription(productDto.getDescription());
    product.setPrice(productDto.getPrice());
    Category category = new Category();
    category.setTitle(productDto.getCategory().getTitle());
    category.setDescription(productDto.getCategory().getDescription());
    category.setId(productDto.getCategory().getId());

    product.setCategory(category);
    return product;
  }
}
