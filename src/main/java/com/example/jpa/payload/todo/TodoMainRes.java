package com.example.jpa.payload.todo;

import java.util.List;

public record TodoMainRes(
        List<TodoResponse> todo

) {
}
