package com.example.jpa.payload.article;

import com.example.jpa.payload.category.CategoryRequest;
import com.example.jpa.payload.category.CategoryResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ArticleResponse {
    private Long id;
    private String title;;
    private String description;
    private List<CategoryResponse> categoryResponses;
    private Long userId;
    private Boolean published =false;

    @Builder
    public ArticleResponse(Long id,String title, String description, List<CategoryResponse> categoryResponses, Long userId, Boolean published){
        this.id = id;
        this.title=title;
        this.description=description;
        this.categoryResponses=categoryResponses;
        this.userId=userId;
        this.published=published;
    }
}
