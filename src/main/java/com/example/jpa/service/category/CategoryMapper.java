package com.example.jpa.service.category;

import com.example.jpa.domain.category.Category;
import com.example.jpa.domain.category.CategoryRepository;
import com.example.jpa.payload.category.CategoryRequest;
import com.example.jpa.payload.category.CategoryResponse;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryMapper(CategoryRepository categoryRepository) {
    }

    public Category mapCategoryEntity(CategoryRequest categoryRequest){
        return Category.builder()
                .name(categoryRequest.getName())
                .build();
    }
    public CategoryResponse mapToResponse(Category category){
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
