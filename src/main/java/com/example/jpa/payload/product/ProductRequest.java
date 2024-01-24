package com.example.jpa.payload.product;

public record ProductRequest (

        String name,
        Double price,
        int quantity,
        String description,
        String date,
        Integer rating
){

}
