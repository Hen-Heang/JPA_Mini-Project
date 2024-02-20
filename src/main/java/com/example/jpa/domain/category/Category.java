package com.example.jpa.domain.category;

import com.example.jpa.domain.article.Article;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;


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

//    @JsonManagedReference
//    @ManyToMany( mappedBy = "categories")
//    private List<Article> articles;

    @Builder
    public Category(String name){
        this.name = name;
    }

    }

