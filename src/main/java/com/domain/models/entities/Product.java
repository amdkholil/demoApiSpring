package com.domain.models.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="product")
public class Product implements Serializable{

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private long id;

  @NotEmpty(message="Name is required")
  private String name;
  
  @NotEmpty(message="Desc is required")
  private String desc;
  
  private double price;
  
  @ManyToOne
  private Category category;

  @ManyToMany()
  @JoinTable(
      name = "product_supplier",
      joinColumns = @JoinColumn(name="product_id"),
      inverseJoinColumns = @JoinColumn(name="supplier_id")
  )
  private Set<Supplier> suppliers;
  
  public Product(){

  }

  public Product(long id, String name, String desc, double price) {
    this.id = id;
    this.name = name;
    this.desc = desc;
    this.price = price;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Set<Supplier> getSuppliers() {
    return suppliers;
  }

  public void setSuppliers(Set<Supplier> suppliers) {
    this.suppliers = suppliers;
  }

}
