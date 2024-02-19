package com.example.jpa.domain.category;

import com.example.jpa.domain.article.Article;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "category_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Article>articles;

    @Builder
    public Category(String name){
        this.name = name;
    }

    public CategoryDTO toDto() {
        return new CategoryDTO(this.id, this.name);
    }
}
