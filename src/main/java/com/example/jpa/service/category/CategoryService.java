package com.example.jpa.service.category;

import com.example.jpa.payload.category.CategoryRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {

    void createCategory(CategoryRequest categoryRequest);


    Object getAllCategory(Pageable pageable);

    Object getCategoryById(Long id);

    Object getCategoryByName(String categoryName, Pageable pageable);

    void updateCategory(Long id, CategoryRequest categoryRequest);

    void deleteCategory(Long id);
}
