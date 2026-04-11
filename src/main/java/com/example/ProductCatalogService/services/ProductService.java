package com.example.ProductCatalogService.services;

import com.example.ProductCatalogService.dtos.FakeStoreProductDto;
import com.example.ProductCatalogService.models.Category;
import com.example.ProductCatalogService.models.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService implements IProductService {

  @Autowired private RestTemplateBuilder restTemplateBuilder;

  @Override
  public Product getProductById(Long id) {
    // Implementation to retrieve a product by its ID
    RestTemplate restTemplate = restTemplateBuilder.build();

//    here it directly returns the product without checking
//      if the API call was successful or not, which can lead to a NullPointerException if the API returns null.
//          It's important to check if the response is null before trying to map it to a Product object.
//    FakeStoreDto fakeStoreDto =
//        restTemplate.getForObject("https://fakestoreapi.com/products/{id}", FakeStoreDto.class, id);

    try {
      ResponseEntity<FakeStoreProductDto> fakeStoreDto =
          restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreProductDto.class, id);

      if (fakeStoreDto.getStatusCode().is2xxSuccessful() && fakeStoreDto.getBody() != null) {
        return mapFakeStoreDtoToProduct(fakeStoreDto.getBody());
      }
    } catch (RestClientResponseException ex) {
      System.out.println("Response from Fake Store API: " + ex.getStatusCode().value());
    }
    return null; // Placeholder return statement
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

  private Product mapFakeStoreDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
    Product product = new Product();
    product.setId(fakeStoreProductDto.getId());
    product.setTitle(fakeStoreProductDto.getTitle());
    product.setDescription(fakeStoreProductDto.getDescription());
    product.setPrice(fakeStoreProductDto.getPrice());
    product.setImageUrl(fakeStoreProductDto.getImage());

    Category category = new Category();
    category.setTitle(fakeStoreProductDto.getCategory());

    product.setCategory(category);
    return product;
  }
}
