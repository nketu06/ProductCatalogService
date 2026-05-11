package com.example.ProductCatalogService.controllers;

import com.example.ProductCatalogService.dtos.SearchRequestDto;
import com.example.ProductCatalogService.models.Product;
import com.example.ProductCatalogService.services.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
public class SearchController {

  @Autowired private ISearchService searchService;

  @PostMapping
  Page<Product> searchProducts(@RequestBody SearchRequestDto searchRequestDto) {

    return searchService.serachProducts(
        searchRequestDto.getQuery(),
        searchRequestDto.getPageNumber(),
        searchRequestDto.getPageSize());
  }
}
