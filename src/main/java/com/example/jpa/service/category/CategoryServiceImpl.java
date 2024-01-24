package com.example.jpa.service.category;

import com.example.jpa.domain.category.CategoryRepository;
import com.example.jpa.exception.CusNotFoundException;
import com.example.jpa.payload.category.CategoryMainRes;
import com.example.jpa.payload.category.CategoryRequest;
import com.example.jpa.payload.category.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Object getAllCategory() {
        var categoriesList = categoryRepository.findAll();
        List<CategoryResponse> categoryResponses = categoriesList.stream()
                .map(categoryMapper::mapToResponse)
                .toList();
        return new CategoryMainRes(categoryResponses);
    }

    @Override
    public Object getCategoryById(Long id) {

        return categoryRepository.findById(id)
                .map(categoryMapper::mapToResponse)
                .orElseThrow(() -> new CusNotFoundException("Category Not Found!"));
    }

//    @Override
//    public Object searchCategoryByName(String name, Integer pageNo, Integer pageSize) {
//       Pageable = (Pageable) PageRequest.of(pageNo,pageSize);
//        Page<CategoryRequest>categoryRequests = categoryRepository.findByNameContainingIgnoreCase(pageable,name).map(Category::)
//        return null;
//    }


}
