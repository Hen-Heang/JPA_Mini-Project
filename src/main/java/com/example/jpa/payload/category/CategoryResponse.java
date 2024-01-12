package com.example.jpa.payload.category;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class CategoryResponse {
    private Long id;
    private String name;

    @Builder
    public CategoryResponse(Long id, String name){
        this.id=id;
        this.name=name;
    }
}
