package com.example.jpa.payload.todo;


import com.example.jpa.domain.todo.Todo;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor

public class TodoResponse {

    private String title;

    @Builder
    public TodoResponse(String title) {
        this.title = title;
    }

    public TodoResponse(Todo todo) {
        this.title = todo.getTitle();

    }
}
