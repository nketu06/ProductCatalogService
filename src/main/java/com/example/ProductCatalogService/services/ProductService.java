package com.example.ProductCatalogService.services;

import com.example.ProductCatalogService.dtos.FakeStoreDto;
import com.example.ProductCatalogService.models.Category;
import com.example.ProductCatalogService.models.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService implements IProductService {

  @Autowired private RestTemplateBuilder restTemplateBuilder;

  @Override
  public Product getProductById(Long id) {
    // Implementation to retrieve a product by its ID
    RestTemplate restTemplate = restTemplateBuilder.build();
    FakeStoreDto fakeStoreDto =
        restTemplate.getForObject("https://fakestoreapi.com/products/{id}", FakeStoreDto.class, id);

    assert fakeStoreDto != null;
    return mapFakeStoreDtoToProduct(fakeStoreDto);
  }

  @Override
  public List<Product> getAllProducts() {
    // Implementation to retrieve all products
    return null; // Placeholder return statement
  }

  @Override
  public Product createProduct(Product product) {
    // Implementation to create a new product
    return null; // Placeholder return statement
  }

  @Override
  public Product replaceProduct(Long id, Product product) {
    // Implementation to replace an existing product by its ID
    return null; // Placeholder return statement
  }

  private Product mapFakeStoreDtoToProduct(FakeStoreDto fakeStoreDto) {
    Product product = new Product();
    product.setId(fakeStoreDto.getId());
    product.setTitle(fakeStoreDto.getTitle());
    product.setDescription(fakeStoreDto.getDescription());
    product.setPrice(fakeStoreDto.getPrice());
    product.setImageUrl(fakeStoreDto.getImage());

    Category category = new Category();
    category.setTitle(fakeStoreDto.getCategory());

    product.setCategory(category);
    return product;
  }
}
