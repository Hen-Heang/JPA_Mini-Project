package com.example.jpa.service.todo;

import com.example.jpa.domain.todo.Todo;
import com.example.jpa.domain.todo.TodoRepository;
import com.example.jpa.payload.todo.TodoRequest;
import com.example.jpa.payload.todo.TodoResponse;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {
    private final TodoRepository todoRepository;

    public TodoMapper(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    public Todo mapTodoEntity(TodoRequest payload){
        return Todo.builder()
                .title(payload.title())
                .build();
    }

    public TodoResponse mapToResponse(Todo todo) {
        return TodoResponse.builder()
                .title(todo.getTitle())
                .build();
    }

    public void updateEntity(Todo todo, TodoRequest payload){
        todo.setTitle(payload.title());

    }
}
