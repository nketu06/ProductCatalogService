package com.example.ProductCatalogService.repos;

import com.example.ProductCatalogService.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 optional @Repository since its interface,
 but it is a good practice to annotate it with @Repository to indicate that it's a Spring Data repository.
 This allows Spring to automatically detect it during component scanning and enables exception
 translation for database operations.
 **/
@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
}
