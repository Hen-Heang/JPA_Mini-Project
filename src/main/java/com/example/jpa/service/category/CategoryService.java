package com.example.jpa.service.category;

import com.example.jpa.payload.category.CategoryRequest;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {

    void createCategory(CategoryRequest categoryRequest);

    Object getAllCategory();

    Object getCategoryById(Long id);

//    Object searchCategoryByName(String name, Integer pageNo, Integer pageSize);
}
