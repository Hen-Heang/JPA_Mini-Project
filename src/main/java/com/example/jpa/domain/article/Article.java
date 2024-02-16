package com.example.jpa.domain.article;

import com.example.jpa.domain.bookmark.BookMark;
import com.example.jpa.domain.category.Category;
import com.example.jpa.domain.comment.Comments;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "articles")

public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long id;

    @Column(name = "article_tile")
    private String title;

    @Column(name = "article_description")
    private String description;

    @Column(name = "article_publish")
    private Boolean published;

    @OneToMany(mappedBy = "article")
    private List<Comments> comments = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "articles",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    List<Category> categories;
    @OneToMany(mappedBy = "article")
    private List<BookMark> bookMarks;

}
