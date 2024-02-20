package com.example.jpa.payload.article;

import com.example.jpa.payload.category.CategoryRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class ArticleRequest {
    private String title;;
    private String description;
    @JsonProperty("categoryRequests")
    private Set<CategoryRequest> categoryRequests;
    private Long userId;
    private Boolean published =false;

    public ArticleRequest(String title, String description, Set<CategoryRequest> categoryRequests, Long userId, Boolean published) {
        this.title = title;
        this.description = description;
        this.categoryRequests = categoryRequests;
        this.userId = userId;
        this.published = published;
    }

}
