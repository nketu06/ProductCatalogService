package com.example.ProductCatalogService.models;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class BaseModel {
    private long id;
    private Date createdAt;
    private Date lastUpdatedAt;
    private State state;
}
