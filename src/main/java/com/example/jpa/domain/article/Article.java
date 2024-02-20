package com.example.jpa.domain.article;

import com.example.jpa.domain.bookmark.BookMark;
import com.example.jpa.domain.category.Category;
import com.example.jpa.domain.comment.Comments;
import com.example.jpa.domain.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
@Entity

public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long id;

    @Column(name = "article_title")
    private String title;

    @Column(name = "article_description")
    private String description;

    @Column(name = "article_publish")
    private Boolean published;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "article",  cascade = CascadeType.ALL)
    private List<Comments> comments = new ArrayList<>();


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "article_categories",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "categories_id")
    )
    List<Category> categories = new ArrayList<>();

    @OneToMany(mappedBy = "article")
    private List<BookMark> bookmarks;
    @Builder
    public Article(Long id, String title, String description, Boolean published, User user, List<Comments> comments, List<Category> categories, List<BookMark> bookMarks) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.published = published;
        this.user = user;
        this.comments = comments;
        this.categories = categories;
        this.bookmarks = bookMarks;
    }
    }



