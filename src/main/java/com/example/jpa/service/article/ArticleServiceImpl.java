package com.example.jpa.service.article;

import com.example.jpa.common.Pagination;
import com.example.jpa.domain.article.Article;
import com.example.jpa.domain.article.ArticleRepository;
import com.example.jpa.domain.category.Category;
import com.example.jpa.domain.category.CategoryRepository;
import com.example.jpa.domain.comment.CommentRepository;
import com.example.jpa.domain.comment.Comments;
import com.example.jpa.domain.user.User;
import com.example.jpa.domain.user.UserRepository;
import com.example.jpa.exception.CusNotFoundException;
import com.example.jpa.exception.NullExceptionClass;
import com.example.jpa.payload.article.ArticleMainRes;
import com.example.jpa.payload.article.ArticleRequest;
import com.example.jpa.payload.article.ArticleResponse;
import com.example.jpa.payload.category.CategoryRequest;
import com.example.jpa.payload.comment.CommentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final ArticleMapper articleMapper;
    private final CommentRepository commentRepository;

    @Override
    public void createArticle(ArticleRequest articleRequest) {
        if (articleRequest.getTitle() == null || articleRequest.getTitle().isBlank()) {
            throw new NullExceptionClass("title can not be blank or empty", "Article");
        } else if (articleRequest.getDescription() == null || articleRequest.getDescription().isBlank()) {
            throw new NullExceptionClass("description can not be blank or empty", "Article");
        }
        List<Category> categories = new ArrayList<>();
        for (CategoryRequest categoryRequest : articleRequest.getCategoryRequests()) {
            if (categoryRequest.getName() == null || categoryRequest.getName().isBlank()) {
                throw new NullExceptionClass("Category can not be empty or blank", "Article");
            }
            Category category = categoryRepository.findByName(categoryRequest.getName()).orElseThrow(()
                    -> new CusNotFoundException("Category not found"));
            categories.add(category);
        }
        User user = userRepository.findById(articleRequest.getUserId())
                .orElseThrow(() -> new CusNotFoundException("User not found"));
        Article article = Article.builder()
                .title(articleRequest.getTitle())
                .description(articleRequest.getDescription())
                .categories(categories)
                .user(user)
                .published(articleRequest.getPublished())
                .build();
        articleRepository.save(article);
    }

    @Override
    public Object getAllArticle(Pageable pageable) {
        List<Article> articleList = articleRepository.findAll();
        Page<Article> articles = articleRepository.findAll(pageable);
        List<ArticleResponse> articleResponseList = articleList.stream()
                .map(articleMapper::mapToResponse)
                .collect(Collectors.toList());
        return new ArticleMainRes(articleResponseList, new Pagination(articles));
    }

    @Override
    public ArticleResponse getArticleById(Long id) {
        Optional<Article> optionalArticle = articleRepository.findById(id); // Use Optional for better handling
        return optionalArticle.map(articleMapper::mapToResponse)
                .orElseThrow(() -> new CusNotFoundException("Article Not Found!"));

    }

    @Override
    public Object getArticleByTitle(String title) {
        String articleLowerCase = title.toLowerCase();
        Article article = articleRepository.findByTitle(articleLowerCase)
                .orElseThrow(() -> new CusNotFoundException("Article with title: " + title + " not found"));
        return articleMapper.mapToResponse(article);
    }

    @Override
    public void updateArticle(Long id, ArticleRequest articleRequest) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() ->
                        new CusNotFoundException("Article Not Found with id: " + id));
        articleMapper.updateArticleEntity(article, articleRequest);
        articleRepository.save(article);
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public void postComment(CommentRequest commentRequest) {
        Article article = articleRepository.findById(commentRequest.getArticleId())
                .orElseThrow(() -> new CusNotFoundException("Article not found with id: " + commentRequest.getArticleId()));
        System.out.println("Id" + article);
        Comments comment = articleMapper.mapCommentEntity(commentRequest, article);
        commentRepository.save(comment);
    }

    @Override
    public Object getCommentByArticleId(Long articleId) {
        Optional<Comments> comments = commentRepository.findCommentsByArticleId(articleId);
        return comments.map(articleMapper::mapCommentToCommentResponse)
                .orElseThrow(() -> new CusNotFoundException("Article Not Found!"));
    }

    @Override
    public Object getArticleIsPublished(Pageable pageable) {
        Page<Article> articlePage = articleRepository.findArticleByPublished(pageable, true);
        List<ArticleResponse> articleResponseList = articlePage.getContent().stream()
                .map(articleMapper::mapToResponse)
                .collect(Collectors.toList());
        return new ArticleMainRes(articleResponseList, new Pagination(articlePage));
    }
}
