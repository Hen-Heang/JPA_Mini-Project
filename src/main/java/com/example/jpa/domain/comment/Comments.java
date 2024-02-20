package com.example.jpa.domain.comment;

import com.example.jpa.domain.article.Article;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
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

//    public CommentDTO toDto(){
//        return new CommentDTO(this.id, this.caption);
//    }

}
