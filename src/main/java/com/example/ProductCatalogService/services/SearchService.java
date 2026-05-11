package com.example.ProductCatalogService.services;

import com.example.ProductCatalogService.models.Product;
import com.example.ProductCatalogService.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SearchService implements ISearchService {

  @Autowired ProductRepo productRepo;

  @Override
  public Page<Product> serachProducts(String query, Integer pageNumber, Integer pageSize) {
    Sort sort = Sort.by("price").descending().and(Sort.by("title"));
    return productRepo.findProductByTitle(query, PageRequest.of(pageNumber, pageSize, sort));
  }
}
