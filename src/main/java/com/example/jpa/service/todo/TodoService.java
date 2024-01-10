package com.example.jpa.service.todo;

import com.example.jpa.payload.todo.TodoRequest;


public interface TodoService {


    void createTodo(TodoRequest payload);

    Object getAllTodo();

    Object getById(Long id);

    Object updateTodo(Long id, TodoRequest payload);


    void deleteById(Long id);
}
