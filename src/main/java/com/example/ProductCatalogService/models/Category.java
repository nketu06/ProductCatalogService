package com.example.ProductCatalogService.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
  private String title;
  private String description;

  //  by default lazy
  @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
  @Fetch(FetchMode.SELECT)
  @JsonBackReference
  private List<Product> products;
}
