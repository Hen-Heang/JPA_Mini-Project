package com.example.jpa.service.article;

import com.example.jpa.payload.articles.ArticleRequest;
import com.example.jpa.payload.comment.CommentRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ArticleService {
    void createArticle(ArticleRequest articleRequest);

    Object getAllArticle(Pageable pageable);

    Object getArticleById(Long id);

    Object getArticleByTitle(String title);

    void updateArticle(Long id, ArticleRequest articleRequest);

    void deleteArticle(Long id);

    void postComment(CommentRequest commentRequest);

    Object getCommentByArticleId(Long articleId);

    Object getArticleIsPublished(Pageable pageable);
}
