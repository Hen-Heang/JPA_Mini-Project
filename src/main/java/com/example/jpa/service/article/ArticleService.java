package com.example.jpa.service.article;

import com.example.jpa.payload.article.ArticleRequest;
import org.springframework.stereotype.Service;

@Service
public interface ArticleService {
    void createArticle(ArticleRequest articleRequest);

    Object getAllArticle();

    Object getArticleById(Long id);

    Object getArticleByTitle(String title);

    void updateArticle(Long id, ArticleRequest articleRequest);

    void deleteArticle(Long id);
}
