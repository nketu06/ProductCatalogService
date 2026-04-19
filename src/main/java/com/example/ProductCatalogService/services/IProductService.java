package com.example.ProductCatalogService.services;

import com.example.ProductCatalogService.models.Product;
import java.util.List;

public interface IProductService {
  Product getProductById(Long id);

  List<Product> getAllProducts();

  Product createProduct(Product product);

  Product replaceProduct(Long id, Product product);

  Boolean deleteProductById(Long id);
}
