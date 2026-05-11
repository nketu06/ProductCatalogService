package com.example.ProductCatalogService.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchRequestDto {
  private String query;
  private Integer pageSize;
  private Integer pageNumber;
}
