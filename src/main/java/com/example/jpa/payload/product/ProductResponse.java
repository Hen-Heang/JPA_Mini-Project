package com.example.jpa.payload.product;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductResponse {
    private Long id;
    private String name;
    private Double price;
    private int quantity;
    private String description;
    private String date;
    private Integer rating;

    @Builder
    public ProductResponse(Long id, String name, Double price, int quantity, String description, String date, Integer rating){
        this.id = id;
        this.name = name;
        this.price= price;
        this.quantity= quantity;
        this.description= description;
        this.date=date;
        this.rating=rating;
    }

}
