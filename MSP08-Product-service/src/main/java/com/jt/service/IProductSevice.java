package com.jt.service;

import java.util.List;
import java.util.Optional;

import com.jt.Entity.Product;

public interface IProductSevice {
 public String registerProduct(Product product);
 public Optional<Product> findById(Long id);
 public List<Product> getAllProducts();
 public String deleteById(Long id);
String updateProduct(Product product);
 
 
}
