// package com.example.ProductCatalogService.config;
//
// import com.example.ProductCatalogService.models.Category;
// import com.example.ProductCatalogService.models.Product;
// import com.example.ProductCatalogService.repository.CategoryRepo;
// import com.example.ProductCatalogService.repository.ProductRepo;
// import java.util.List;
// import lombok.RequiredArgsConstructor;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;
//
// @Component
// @RequiredArgsConstructor
// public class CategoryDataSeeder implements CommandLineRunner {
//  private final CategoryRepo categoryRepo;
//  private final ProductRepo productRepo;
//
//  @Override
//  public void run(String... args) {
//    List<Category> seedCategories =
//        List.of(
//            createCategory(1L, "Electronics", "Phones, laptops, and accessories"),
//            createCategory(2L, "Fashion", "Clothing, shoes, and lifestyle items"),
//            createCategory(3L, "Home", "Furniture, kitchen, and home essentials"),
//            createCategory(4L, "Books", "Fiction, non-fiction, and educational books"));
//
//    List<Category> missingCategories =
//        seedCategories.stream().filter(category ->
// !categoryRepo.existsById(category.getId())).toList();
//
//    if (!missingCategories.isEmpty()) {
//      categoryRepo.saveAll(missingCategories);
//    }
//
//    seedProducts();
//  }
//
//  private void seedProducts() {
//    Category electronics = categoryRepo.findById(1L).orElse(null);
//    Category fashion = categoryRepo.findById(2L).orElse(null);
//    Category home = categoryRepo.findById(3L).orElse(null);
//    Category books = categoryRepo.findById(4L).orElse(null);
//
//    if (electronics == null || fashion == null || home == null || books == null) {
//      return;
//    }
//
//    List<Product> seedProducts =
//        List.of(
//            createProduct(
//                101L,
//                "Smartphone X1",
//                "https://example.com/images/smartphone-x1.jpg",
//                "6.5 inch display, 128GB storage",
//                499.99,
//                electronics),
//            createProduct(
//                102L,
//                "Ultra Laptop 14",
//                "https://example.com/images/ultra-laptop-14.jpg",
//                "Lightweight laptop for work and study",
//                899.00,
//                electronics),
//            createProduct(
//                201L,
//                "Denim Jacket",
//                "https://example.com/images/denim-jacket.jpg",
//                "Classic fit blue denim jacket",
//                59.99,
//                fashion),
//            createProduct(
//                202L,
//                "Running Shoes",
//                "https://example.com/images/running-shoes.jpg",
//                "Breathable running shoes for daily training",
//                79.99,
//                fashion),
//            createProduct(
//                301L,
//                "Wooden Coffee Table",
//                "https://example.com/images/coffee-table.jpg",
//                "Modern wooden center table for living room",
//                149.50,
//                home),
//            createProduct(
//                302L,
//                "Non-Stick Cookware Set",
//                "https://example.com/images/cookware-set.jpg",
//                "8-piece non-stick cookware for everyday use",
//                99.00,
//                home),
//            createProduct(
//                401L,
//                "Clean Code",
//                "https://example.com/images/clean-code.jpg",
//                "A Handbook of Agile Software Craftsmanship",
//                34.99,
//                books),
//            createProduct(
//                402L,
//                "Atomic Habits",
//                "https://example.com/images/atomic-habits.jpg",
//                "An easy and proven way to build good habits",
//                19.99,
//                books));
//
//    List<Product> missingProducts =
//        seedProducts.stream().filter(product ->
// !productRepo.existsById(product.getId())).toList();
//
//    if (!missingProducts.isEmpty()) {
//      productRepo.saveAll(missingProducts);
//    }
//  }
//
//  private Category createCategory(Long id, String title, String description) {
//    Category category = new Category();
//    category.setId(id);
//    category.setTitle(title);
//    category.setDescription(description);
//    return category;
//  }
//
//  private Product createProduct(
//      Long id,
//      String title,
//      String imageUrl,
//      String description,
//      double price,
//      Category category) {
//    Product product = new Product();
//    product.setId(id);
//    product.setTitle(title);
//    product.setImageUrl(imageUrl);
//    product.setDescription(description);
//    product.setPrice(price);
//    product.setCategory(category);
//    product.setSalesSpecific(false);
//    return product;
//  }
// }
//
