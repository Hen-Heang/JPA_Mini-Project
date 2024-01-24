package com.example.jpa.payload.post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostResponse {
    private Long id;
    private String title;
    private String description;

    @Builder
    public PostResponse(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

}
