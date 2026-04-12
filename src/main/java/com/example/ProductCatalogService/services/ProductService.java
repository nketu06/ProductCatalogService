package com.example.ProductCatalogService.services;

import com.example.ProductCatalogService.dtos.FakeStoreProductDto;
import com.example.ProductCatalogService.models.Category;
import com.example.ProductCatalogService.models.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.*;

@Service
public class ProductService implements IProductService {

  @Autowired private RestTemplateBuilder restTemplateBuilder;

  @Override
  public Product getProductById(Long id) {
    // Implementation to retrieve a product by its ID
    //    RestTemplate restTemplate = restTemplateBuilder.build();

    //    here it directly returns the product without checking
    //      if the API call was successful or not, which can lead to a NullPointerException if the
    // API returns null.
    //          It's important to check if the response is null before trying to map it to a Product
    // object.
    //    FakeStoreDto fakeStoreDto =
    //        restTemplate.getForObject("https://fakestoreapi.com/products/{id}",
    // FakeStoreDto.class, id);

    try {
      ResponseEntity<FakeStoreProductDto> fakeStoreDto =
          requestForEntity(
              HttpMethod.GET,
              "https://fakestoreapi.com/products/{id}",
              null,
              FakeStoreProductDto.class,
              id);

      if (validateFakeStoreResponse(fakeStoreDto)) {
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
    FakeStoreProductDto fakeStoreProductDto = mapProductToFakeStoreDto(product);
    ResponseEntity<FakeStoreProductDto> response =
        requestForEntity(
            HttpMethod.PUT,
            "https://fakestoreapi.com/products/{id}",
            fakeStoreProductDto,
            FakeStoreProductDto.class,
            id);

    if (validateFakeStoreResponse(response)) {
      return mapFakeStoreDtoToProduct(response.getBody());
    }
    return null; // Placeholder return statement
  }

  private boolean validateFakeStoreResponse(ResponseEntity<?> response) {
    return response.getStatusCode().is2xxSuccessful() && response.getBody() != null;
  }

  private <T> ResponseEntity<T> requestForEntity(
      HttpMethod httpMethod,
      String url,
      @Nullable Object request,
      Class<T> responseType,
      Object... uriVariables)
      throws RestClientException {
    RestTemplate restTemplate = restTemplateBuilder.build();
    RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
    ResponseExtractor<ResponseEntity<T>> responseExtractor =
        restTemplate.responseEntityExtractor(responseType);
    return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
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

  private FakeStoreProductDto mapProductToFakeStoreDto(Product product) {
    FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
    fakeStoreProductDto.setId(product.getId());
    fakeStoreProductDto.setTitle(product.getTitle());
    fakeStoreProductDto.setDescription(product.getDescription());
    fakeStoreProductDto.setPrice(product.getPrice());
    fakeStoreProductDto.setImage(product.getImageUrl());
    if (product.getCategory() != null) {
      fakeStoreProductDto.setCategory(product.getCategory().getTitle());
    }
    return fakeStoreProductDto;
  }
}
