package com.example.ProductCatalogService.repository;

import com.example.ProductCatalogService.models.Category;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

  Optional<Category> findById(Long id);
}
