package com.example.jpa.controller;

import com.example.jpa.payload.category.CategoryRequest;
import com.example.jpa.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
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
    public Object getAllCategory(){
        return ok(categoryService.getAllCategory());
    }

    @GetMapping("/{id}")
    public Object getCategoryById(@PathVariable("id")Long id){
        return ok(categoryService.getCategoryById(id));
    }



}
