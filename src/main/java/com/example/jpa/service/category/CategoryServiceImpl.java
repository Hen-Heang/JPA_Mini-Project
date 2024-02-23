package com.example.jpa.service.category;

import com.example.jpa.common.Pagination;
import com.example.jpa.domain.category.Category;
import com.example.jpa.domain.category.CategoryRepository;
import com.example.jpa.exception.CusNotFoundException;
import com.example.jpa.payload.category.CategoryMainRes;
import com.example.jpa.payload.category.CategoryRequest;
import com.example.jpa.payload.category.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public void createCategory(CategoryRequest categoryRequest) {
        var category = categoryMapper.mapCategoryEntity(categoryRequest);
        categoryRepository.save(category);

    }

    @Override
    public Object getAllCategory(Pageable pageable) {
        Page<Category> categoryPage = categoryRepository.findAll(pageable);
        var categoriesList = categoryRepository.findAll();
        List<CategoryResponse> categoryResponses = categoriesList.stream()
                .map(categoryMapper::mapToResponse)
                .toList();
        return new CategoryMainRes(categoryResponses, new Pagination(categoryPage));
    }

    @Override
    public Object getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::mapToResponse)
                .orElseThrow(() -> new CusNotFoundException("Category Not Found!"));
    }
    @Override
    public Object getCategoryByName(String categoryName, Pageable pageable) {
        String lowercaseCategory = categoryName.toLowerCase();
        Page<Category> categoryPage = categoryRepository.findCategoriesByName(lowercaseCategory, pageable);
        List<CategoryResponse> categoryResponses = categoryPage.getContent().stream()
                .map(categoryMapper::mapToResponse)
                .collect(Collectors.toList());
        return new CategoryMainRes(categoryResponses, new Pagination(categoryPage));
    }

    @Override
    public void updateCategory(Long id, CategoryRequest categoryRequest) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CusNotFoundException("Category Not Found!"));
        categoryMapper.updateCategoryEntity(category, categoryRequest);
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

}
