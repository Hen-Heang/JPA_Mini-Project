package com.example.jpa.controller;

import com.example.jpa.payload.category.CategoryRequest;
import com.example.jpa.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
public class CategoryController extends AbstractRestController {
    private final CategoryService categoryService;

    @PostMapping("/add")
    public Object createCategory(@RequestBody CategoryRequest categoryRequest) {
        categoryService.createCategory(categoryRequest);
        return ok();
    }

    @GetMapping("/all")
    public Object getAllCategory(
            @RequestParam(name = "page_number", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(name = "size_number", defaultValue = "10", required = false) Integer sizeNumber
    ) {
        Pageable pageable = PageRequest.of(pageNumber,sizeNumber);
        return ok(categoryService.getAllCategory(pageable));
    }

    @GetMapping("/{id}")
    public Object getCategoryById(@PathVariable("id") Long id) {
        return ok(categoryService.getCategoryById(id));
    }

    @GetMapping("/search/{category}")
    public Object getCategoryByName(@PathVariable String category,
                                    @RequestParam(name = "page_number", defaultValue = "0", required = false) Integer pageNumber,
                                    @RequestParam(name = "size_number", defaultValue = "10", required = false) Integer sizeNumber
                                    ) {
        Pageable pageable = PageRequest.of(pageNumber, sizeNumber);
        return ok(categoryService.getCategoryByName(category, pageable));
    }

    @PutMapping("/{id}")
    public Object updateCategory(@PathVariable("id")Long id, @RequestBody CategoryRequest categoryRequest){
        categoryService.updateCategory(id, categoryRequest);
        return ok();
    }

    @DeleteMapping("/{id}")
    public Object deleteCategory(@PathVariable("id")Long id){
        categoryService.deleteCategory(id);
        return ok();
    }
}
