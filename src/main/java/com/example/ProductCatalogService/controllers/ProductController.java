package com.example.ProductCatalogService.controllers;

import com.example.ProductCatalogService.models.Product;
import com.example.ProductCatalogService.models.State;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        Product product = new Product();
        product.setId(1);
        product.setTitle("iPhone 13");
        product.setDescription("The latest iPhone model with A15 Bionic chip.");
        product.setPrice(999.99);
        product.setState(State.ACTIVE);
        return List.of(product);
    }
}
