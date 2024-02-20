package com.example.jpa.service.article;

import com.example.jpa.domain.article.Article;
import com.example.jpa.domain.article.ArticleRepository;
import com.example.jpa.domain.category.Category;
import com.example.jpa.payload.article.ArticleResponse;
import com.example.jpa.payload.category.CategoryResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArticleMapper {

    public ArticleMapper(ArticleRepository articleRepository) {
    }

    // Assuming you have this method somewhere that maps a single Category to CategoryResponse
    private CategoryResponse mapCategoryToCategoryResponse(Category category) {
        // Implement the mapping logic here
        return new CategoryResponse(
                category.getId(),
                category.getName()
        );
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
}
