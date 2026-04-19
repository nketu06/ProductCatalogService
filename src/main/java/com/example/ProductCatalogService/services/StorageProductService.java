package com.example.ProductCatalogService.services;

import com.example.ProductCatalogService.exceptions.ProductAlreadyExistException;
import com.example.ProductCatalogService.exceptions.ProductNotFoundException;
import com.example.ProductCatalogService.models.Product;
import com.example.ProductCatalogService.models.State;
import com.example.ProductCatalogService.repository.ProductRepo;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Primary annotation is used to indicate that this implementation of IProductService should be the
 * default
 */
// @Primary
@Service
public class StorageProductService implements IProductService {
  @Autowired private ProductRepo productRepo;

  @Override
  public Product getProductById(Long id) {
    Optional<Product> product = productRepo.findById(id);
    return product.orElse(null);
  }

  @Override
  public List<Product> getAllProducts() {
    return productRepo.findAll();
  }

  @Override
  public Product createProduct(Product product) {
    if (productRepo.findById(product.getId()).isEmpty()) {
      return productRepo.save(product);
    }
    throw new ProductAlreadyExistException(
        "Product with id " + product.getId() + " already exists.");
  }

  @Override
  public Product replaceProduct(Long id, Product product) {
    product.setId(id);
    if (productRepo.findById(id).isPresent()) {
      product.setLastUpdatedAt(new Date());
      return productRepo.save(product);
    }
    throw new ProductNotFoundException("Product with id " + id + " not found.");
  }

  @Override
  public Boolean deleteProductById(Long id) {
    Optional<Product> optionalProduct = productRepo.findById(id);
    if (optionalProduct.isPresent()) {
      Product p = optionalProduct.get();
      if (p.getState().equals(State.INACTIVE)) {
        productRepo.deleteById(id);
        return true;
      } else {
        p.setState(State.INACTIVE);
        productRepo.save(p);
        return true;
      }
    }
    throw new ProductNotFoundException("Product with id " + id + " not found.");
  }
}
