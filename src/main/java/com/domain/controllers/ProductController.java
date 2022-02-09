package com.domain.controllers;

import java.io.Serializable;

import javax.validation.Valid;

import com.domain.dto.ResponseData;
import com.domain.models.entities.Product;
import com.domain.models.entities.Supplier;
import com.domain.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
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
  public Product getId(@PathVariable("id") Long id) {
    return productService.getId(id);
  }

  @PostMapping
  public ResponseEntity<ResponseData<Product>> save(@Valid @RequestBody Product product, Errors errors) {
    ResponseData<Product> responseData = new ResponseData<>();
    if (errors.hasErrors()) {
      for (ObjectError error : errors.getAllErrors()) {
        responseData.getMessages().add(error.getDefaultMessage());
      }
      responseData.setStatus(false);
      responseData.setPayload(null);
      return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(responseData);
    }
    responseData.setStatus(true);
    responseData.setPayload(productService.add(product));
    return ResponseEntity.ok(responseData);
  }

  @PutMapping
  public Product update(@RequestBody Product product) {
    return productService.add(product);
  }

  @DeleteMapping(path = "/{id}")
  public void dropId(@PathVariable Long id) {
    productService.dropId(id);
  }

  @PostMapping(path = "{id}")
  public void addSupplier(@RequestBody Supplier supplier, @PathVariable("id") Long productId) {
    productService.addSupplier(supplier, productId);
  }

}
