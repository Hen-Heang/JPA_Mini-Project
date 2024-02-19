package com.example.jpa.service.article;

import com.example.jpa.common.api.ApiResponse;
import com.example.jpa.domain.article.ArticleRepository;
import com.example.jpa.domain.category.Category;
import com.example.jpa.domain.category.CategoryRepository;
import com.example.jpa.domain.user.User;
import com.example.jpa.domain.user.UserRepository;
import com.example.jpa.exception.CusNotFoundException;
import com.example.jpa.exception.NullExceptionClass;
import com.example.jpa.payload.article.ArticleRequest;
import com.example.jpa.payload.category.CategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;


    @Override
    public void createArticle(ArticleRequest articleRequest) {
        if (articleRequest.getTitle() == null || articleRequest.getTitle().isBlank()){
            throw new NullExceptionClass("title can not be blank or empty", "Article");
        } else if (articleRequest.getDescription() == null || articleRequest.getDescription().isBlank()) {
            throw new NullExceptionClass("description can not be blank or empty", "Article");
        }


        List<Category> categories = new ArrayList<>();
        for (CategoryRequest categoryRequest : articleRequest.getCategoryRequests()){
            if (categoryRequest.getName() == null || categoryRequest.getName().isBlank()){
                throw new NullExceptionClass("Category can not be empty or blank", "Article");
            }
            Category category = categoryRepository.findByName(categoryRequest.getName()).orElseThrow(()
                    -> new CusNotFoundException("Category not found"));
            categories.add(category);
        }


        User user = userRepository.findById(articleRequest.getUserId()).orElseThrow(()
                -> new CusNotFoundException("User not found"));
        return ApiResponse.<ArticleDto>builder()
                .message("successfully create article")
                .payload(articleRepository.save(articleRequest.toEntity(user, categories)).toDto())
                .status(HttpStatus.CREATED)
                .build();

    }
}
