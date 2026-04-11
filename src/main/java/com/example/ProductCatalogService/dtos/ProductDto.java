package com.example.ProductCatalogService.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

  private Long id;
  private String title;
  private String imageUrl;
  private String description;
  private double price;
  private CategoryDto category;
}
