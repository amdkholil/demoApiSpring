package com.domain.services;

import java.util.Optional;

import javax.transaction.Transactional;

import com.domain.models.entities.Product;
import com.domain.models.repos.ProductRepo;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService {
  private ProductRepo productRepo;

  public Product add(Product product){
    return productRepo.save(product);
  }

  public Iterable<Product> getAll(){
    return productRepo.findAll();
  }

  public Optional<Product> getId(Long id){
    return productRepo.findById(id);
  }
}
