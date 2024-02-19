package com.example.jpa.domain.bookmark;

import com.example.jpa.domain.article.ArticleDTO;
import com.example.jpa.domain.user.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkDTO {
    private Long id;
    private ArticleDTO article;
    private UserDTO user;

    public BookmarkDTO(ArticleDTO article) {
        this.article = article;
    }
}
