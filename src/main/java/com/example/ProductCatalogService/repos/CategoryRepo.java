package com.example.ProductCatalogService.repos;


import com.example.ProductCatalogService.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
}
