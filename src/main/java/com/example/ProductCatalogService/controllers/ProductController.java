package com.example.ProductCatalogService.controllers;

import com.example.ProductCatalogService.dtos.ProductDto;
import com.example.ProductCatalogService.models.Product;
import com.example.ProductCatalogService.models.State;
import com.example.ProductCatalogService.services.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

  @Autowired private ProductService productService;

  @GetMapping("/products")
  public List<Product> getAllProducts() {
    Product product = new Product();
    product.setId(1);
    product.setTitle("iPhone 13");
    product.setDescription("The latest iPhone model with A15 Bionic chip.");
    product.setPrice(999.99);
    product.setState(State.ACTIVE);
    return List.of(product);
  }

  @GetMapping("/products/{id}")
  public ProductDto getProductById(@PathVariable("id") Long productId) {
    ProductDto product = new ProductDto();
    product.setId(productId);
    product.setTitle("iPhone 13");
    product.setDescription("The latest iPhone model with A15 Bionic chip.");
    product.setPrice(999.99);
    return product;
  }

  @PostMapping("/products")
  public ProductDto createProduct(@RequestBody ProductDto input) {
    return input;
  }
}
