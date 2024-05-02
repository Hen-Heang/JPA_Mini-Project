package com.example.jpa.domain.category;


import jakarta.persistence.*;
import lombok.*;




@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "category_id")
    private Long id;

    @Column(name = "category_name", unique = true)
    private String name;



    @Builder
    public Category(String name){
        this.name = name;
    }

    }

