package com.coffeeshop.java_coffeeshop_backend;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class Products {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String image;
    private Integer price;
    
    public Integer getId() {
        return id;
      }
    
      public void setId(Integer id) {
        this.id = id;
      }
    
      public String getName() {
        return name;
      }
    
      public void setName(String name) {
        this.name = name;
      }
    
      public String getImage() {
        return image;
      }
    
      public void setImage(String image) {
        this.image = image;
      }


      public Integer getPrice() {
        return price;
      }
    
      public void setPrice(Integer price) {
        this.price = price;
      }
}
