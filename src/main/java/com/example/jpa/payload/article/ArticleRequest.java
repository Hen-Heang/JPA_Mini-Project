package com.example.jpa.payload.article;

import com.example.jpa.payload.category.CategoryRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class ArticleRequest {
    private String title;;
    private String description;
    @JsonProperty("categoryRequests")
    private List<CategoryRequest> categoryRequests;
    private Long userId;
    private Boolean published =false;

    public ArticleRequest(String title, String description, List<CategoryRequest> categoryRequests, Long userId, Boolean published) {
        this.title = title;
        this.description = description;
        this.categoryRequests = categoryRequests;
        this.userId = userId;
        this.published = published;
    }

    //    public Article toEntity(User user, List<Category>categories){
//    return new Article(null, this.title, this.description, this.published, user, categories);
//}

//public Article toEntity(Long id, User user, List<Category>categories){
//    return new Article(id, this.title, this.description, this.published, user,categories)
//}
}
