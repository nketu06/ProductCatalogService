package com.example.ProductCatalogService.models;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category extends BaseModel {
  private String title;
  private String description;
  private List<Product> products;
}
