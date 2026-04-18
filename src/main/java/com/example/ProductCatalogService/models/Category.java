package com.example.ProductCatalogService.models;

import jakarta.persistence.Entity;
import java.util.List;

import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
  private String title;
  private String description;
  @OneToMany(mappedBy = "category")
  private List<Product> products;
}
