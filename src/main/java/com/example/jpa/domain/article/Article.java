package com.example.jpa.domain.article;

import com.example.jpa.domain.bookmark.BookMark;
import com.example.jpa.domain.category.Category;
import com.example.jpa.domain.comment.Comments;
import com.example.jpa.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.yaml.snakeyaml.events.Event.ID.Comment;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

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

    public ArticleDTO toDto(){
        return new ArticleDTO(this.id, this.title, this.description, this.published, this.user.toDto(), this.comments.stream().map(Comments::toDto).collect(Collectors.toList()), this.categories.stream().map(Category::toDto).collect(Collectors.toList()));
    }
}
