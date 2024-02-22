package com.example.jpa.payload.comment;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentResponse {
    private Long id;
    private String description;

    @Builder
    public CommentResponse(Long id, String description) {
        this.id = id;
        this.description = description;
    }
}
