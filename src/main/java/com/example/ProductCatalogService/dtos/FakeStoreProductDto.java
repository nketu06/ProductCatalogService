package com.example.ProductCatalogService.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
  Long id;
  String title;
  String description;
  String category;
  String image;
  double price;
}
