package com.example.ProductCatalogService.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
public abstract class BaseModel {
  @Id private long id;
  private Date createdAt;
  private Date lastUpdatedAt;
  private State state;

  public BaseModel() {
    this.createdAt = new Date();
    this.lastUpdatedAt = new Date();
    this.state = State.ACTIVE;
  }
}
