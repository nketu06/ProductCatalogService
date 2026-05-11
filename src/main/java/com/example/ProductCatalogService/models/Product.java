package com.example.ProductCatalogService.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
  private String title;
  private String imageUrl;
  private String description;
  private double price;

  @ManyToOne(cascade = CascadeType.ALL) // Form Product to Category
  @JsonManagedReference
  private Category category;

  private boolean isSalesSpecific;
}
