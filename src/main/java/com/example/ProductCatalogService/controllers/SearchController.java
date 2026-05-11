package com.example.ProductCatalogService.controllers;

import com.example.ProductCatalogService.dtos.SearchRequestDto;
import com.example.ProductCatalogService.models.Product;
import com.example.ProductCatalogService.services.ISearchService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
public class SearchController {

  @Autowired private ISearchService searchService;

  @PostMapping
  List<Product> searchProducts(@RequestBody SearchRequestDto searchRequestDto) {

    return searchService.serachProducts(
        searchRequestDto.getQuery(), searchRequestDto.getPageNumber(), searchRequestDto.getPage());
  }
}
