package com.example.jpa.domain.comment;

import com.example.jpa.domain.article.Article;
import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "comment")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(name = "comment_caption")
    private String caption;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

@Builder
    public Comments(String caption, Article article){
    this.caption=caption;
    this.article=article;
}

}
