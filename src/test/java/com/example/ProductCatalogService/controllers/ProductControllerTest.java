package com.example.ProductCatalogService.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.example.ProductCatalogService.dtos.ProductDto;
import com.example.ProductCatalogService.models.Category;
import com.example.ProductCatalogService.models.Product;
import com.example.ProductCatalogService.services.StorageProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class ProductControllerTest {

  @Autowired private ProductController productController;

  @MockBean private StorageProductService storageProductService;

  @Test
  public void test_get_product_by_id_with_valid_product_id() {
    // Arrange
    Product product = new Product();
    product.setId(1L);
    product.setTitle("title");
    product.setDescription("description");
    product.setCategory(new Category());
    when(storageProductService.getProductById(1L)).thenReturn(product);
    // Act [empty]

    // Assert
    ResponseEntity<ProductDto> productById = productController.getProductById(1L);
    assertNotNull(productById);
    assertNotNull(productById.getBody());
    assertEquals(HttpStatus.OK, productById.getStatusCode());
    assertEquals(1L, productById.getBody().getId());
  }

  @Test
  public void test_get_product_by_id_with_invalid_product_id() {
    IllegalArgumentException illegalArgumentException =
        assertThrows(IllegalArgumentException.class, () -> productController.getProductById(-2L));
    assertEquals("Product ID cannot be zero or negative.", illegalArgumentException.getMessage());
  }

  @Test
  public void test_get_product_by_id_with_error_product_service() {

    when(storageProductService.getProductById(1L))
        .thenThrow(new IllegalArgumentException("Error fetching product"));

    IllegalArgumentException illegalArgumentException =
        assertThrows(IllegalArgumentException.class, () -> productController.getProductById(1L));
    assertEquals("Error fetching product", illegalArgumentException.getMessage());
  }
}
