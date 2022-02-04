package com.domain.controllers;

import java.io.Serializable;
import java.util.Optional;

import com.domain.models.entities.Product;
import com.domain.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/product")
public class ProductController implements Serializable {
  @Autowired
  private ProductService productService;

  @GetMapping
  public Iterable<Product> index() {
    return productService.getAll();
  }

  @GetMapping(path = "/{id}")
  public Optional<Product> getId(@PathVariable("id") Long id) {
    return productService.getId(id);
  }

  @PostMapping
  public Product save(@RequestBody Product product) {
    return productService.add(product);
  }

  @PutMapping
  public Product update(@RequestBody Product product) {
    return productService.add(product);
  }

  @DeleteMapping(path = "/{id}")
  public void dropId(@PathVariable Long id) {
    productService.dropId(id);
  }

}
