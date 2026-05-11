package com.example.ProductCatalogService.services;

import com.example.ProductCatalogService.models.Product;
import com.example.ProductCatalogService.repository.ProductRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class SearchService implements ISearchService {

  @Autowired ProductRepo productRepo;

  @Override
  public List<Product> serachProducts(String query, Integer pageNumber, Integer pageSize) {
    return productRepo.findProductByTitle(query, PageRequest.of(pageNumber, pageSize));
  }
}
