package com.example.ProductCatalogService.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreDto {
  Long id;
  String title;
  String description;
  String category;
  String image;
  double price;
}
