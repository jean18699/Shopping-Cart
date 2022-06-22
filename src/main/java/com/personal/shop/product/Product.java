package com.personal.shop.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter @Getter
@NoArgsConstructor
@Entity()
@Table(name="Products")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private double price;

    public Product(String name, String description, double price){
        this.name = name;
        this.description = description;
        this.price = price;
    }

}
