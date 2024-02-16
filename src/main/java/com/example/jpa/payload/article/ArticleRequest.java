package com.example.jpa.payload.article;

import com.example.jpa.payload.category.CategoryRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleRequest {
    private String title;;
    private String description;
    private Set<CategoryRequest> categoryRequests;
    private UUID userId;
    private Boolean published =false;


}
