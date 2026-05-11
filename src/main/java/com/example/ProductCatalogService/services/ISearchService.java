package com.example.ProductCatalogService.services;

import com.example.ProductCatalogService.models.Product;
import java.util.List;

public interface ISearchService {
  List<Product> serachProducts(String query, Integer pageNumber, Integer page);
}
