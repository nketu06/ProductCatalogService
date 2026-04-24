package com.example.ProductCatalogService.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.example.ProductCatalogService.models.Category;
import com.example.ProductCatalogService.models.Product;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CategoryRepoTest {

  @Autowired private CategoryRepo categoryRepo;

  @Test
  @Transactional
  public void testFetchTypes() {
    Optional<Category> category = categoryRepo.findById(3L);
    System.out.println(category.get().getTitle());
    for (Product p : category.get().getProducts()) {
      System.out.println(p.getTitle());
    }
    assertTrue(category.isPresent());
  }

  @Test
  @Transactional
  public void nPlusOneProblem() {
    List<Category> all = categoryRepo.findAll();
    for (Category c : all) {
      System.out.println(c.getTitle());
      for (Product p : c.getProducts()) {
        System.out.println(p.getTitle());
      }
    }
  }
}
