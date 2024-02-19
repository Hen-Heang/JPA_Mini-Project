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
    private final ArticleRepository articleRepository;

    public ArticleMapper(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    // Assuming you have this method somewhere that maps a single Category to CategoryResponse
    private CategoryResponse mapCategoryToCategoryResponse(Category category) {
        // Implement the mapping logic here
        return new CategoryResponse(/* parameters based on your CategoryResponse class */);
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
                .userId(article.getUser().getId()) // Assuming Article has a User associated with it
                .published(article.getPublished())
                .build();
    }
}
