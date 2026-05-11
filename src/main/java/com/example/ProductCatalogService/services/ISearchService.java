package com.example.ProductCatalogService.services;

import com.example.ProductCatalogService.models.Product;
import org.springframework.data.domain.Page;

public interface ISearchService {
  Page<Product> serachProducts(String query, Integer pageNumber, Integer page);
}
