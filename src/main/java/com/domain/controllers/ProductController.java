package com.domain.controllers;

import java.io.Serializable;

import com.domain.models.entities.Product;
import com.domain.models.repos.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/product")
public class ProductController implements Serializable{
  @Autowired
  private ProductRepo productRepo;

  @GetMapping
  public @ResponseBody Iterable<Product> index(){
    return productRepo.findAll();
  }

  @PostMapping("/add")
  public @ResponseBody String add(
    @RequestParam String name, 
    @RequestParam String desc,
    @RequestParam double price
    ){

      Product product = new Product();
      product.setName(name);
      product.setDesc(desc);
      product.setPrice(price);
      productRepo.save(product);
    return "saved";
  }

}
