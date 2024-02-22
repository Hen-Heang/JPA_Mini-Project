package com.example.jpa.service.article;

import com.example.jpa.domain.article.Article;
import com.example.jpa.domain.article.ArticleRepository;
import com.example.jpa.domain.category.Category;
import com.example.jpa.domain.category.CategoryRepository;
import com.example.jpa.domain.comment.Comments;
import com.example.jpa.domain.user.User;
import com.example.jpa.domain.user.UserRepository;
import com.example.jpa.exception.CusNotFoundException;
import com.example.jpa.payload.article.ArticleRequest;
import com.example.jpa.payload.article.ArticleResponse;
import com.example.jpa.payload.category.CategoryRequest;
import com.example.jpa.payload.category.CategoryResponse;
import com.example.jpa.payload.comment.CommentRequest;
import com.example.jpa.payload.comment.CommentResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component

public class ArticleMapper {
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public ArticleMapper(ArticleRepository articleRepository, CategoryRepository categoryRepository,
                         UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    private CategoryResponse mapCategoryToCategoryResponse(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getName()
        );
    }

    public Comments mapCommentEntity(CommentRequest commentRequest, Article article) {
        return  Comments.builder()
                .caption(commentRequest.getCaption())
                .article(article) // Assuming your Comments entity has a field linking to the Article
                .build();
    }



    public ArticleResponse mapToResponse(Article article) {

        List<CategoryResponse> categoryResponses = article.getCategories().stream()
                .map(this::mapCategoryToCategoryResponse)
                .collect(Collectors.toList());

        return ArticleResponse.builder()
                .id(article.getId())
                .title(article.getTitle())
                .description(article.getDescription())
                .categoryResponses(categoryResponses)
                .userId(article.getUser().getId())
                .published(article.getPublished())
                .build();
    }

    public void updateArticleEntity(Article article, ArticleRequest articleRequest) {

        article.setTitle(articleRequest.getTitle());
        article.setDescription(articleRequest.getDescription());

        List<Category> updateCategory = new ArrayList<>();
        for (CategoryRequest categoryRequest : articleRequest.getCategoryRequests()) {
            Category category = categoryRepository.findByName(categoryRequest.getName())
                    .orElseThrow(() -> new CusNotFoundException("Category not found with name: " + categoryRequest.getName()));
            updateCategory.add(category);
        }
        article.setCategories(updateCategory);

        User user = userRepository.findById(articleRequest.getUserId())
                .orElseThrow(()-> new CusNotFoundException("User not found with id : "+articleRequest.getUserId()));
        article.setUser(user);
        article.setPublished(articleRequest.getPublished());
    }

    public CommentResponse mapCommentToCommentResponse(Comments comment) {
        return CommentResponse.builder()
                .id(comment.getId())
                .description(comment.getCaption())
                .build();
    }

    public CommentResponse mapCommentToResponse(Article article) {
        List<CommentResponse> commentResponses = article.getComments().stream()
                .map(this::mapCommentToCommentResponse)
                .toList();
        return CommentResponse.builder()
                .id(article.getId())
                .description(article.getTitle())
                .build();
    }

}
