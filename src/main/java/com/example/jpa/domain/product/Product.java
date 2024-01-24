package com.example.jpa.domain.product;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Double price;
    @Column(name = "qty")
    private int quantity;
    @Column(name = "des")
    private String description;
    @Column(name = "date")
    private String date;
    @Column(name = "rating")
    private Integer rating;

    @Builder
    public Product(String name, Double price, int qty, String description, String date, Integer rating){
        this.name = name;
        this.price = price;
        this.quantity=qty;
        this.description= description;
        this.date=date;
        this.rating = rating;
    }
}
