package com.example.jpa.controller;

import com.example.jpa.payload.todo.TodoRequest;
import com.example.jpa.service.todo.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/todo")
@RequiredArgsConstructor
public class TodoController extends AbstractRestController {
    private final TodoService todoService;

    //    Create to do list
    @PostMapping("/add")
    public Object createTodo(@RequestBody TodoRequest payload) {
        todoService.createTodo(payload);
        return ok();
    }

    //    Get all todoList
    @GetMapping("/all")
    public Object getAllTodo() {
        return ok(todoService.getAllTodo());
    }


    //    Get Todo by id
    @GetMapping("{id}")
    public Object getTodoById(@PathVariable("id") Long id) {
        return ok(todoService.getById(id));
    }

    //    Update todo
    @PutMapping("/{id}")
    public Object updateTodo(@PathVariable("id") @RequestBody Long id, TodoRequest payload) {
        return ok(todoService.updateTodo(id, payload));
    }

    //    Delete to do
    @DeleteMapping("/{id}")
    public Object deleteTodoById(@PathVariable("id") Long id) {
        todoService.deleteById(id);
        return ok();
    }
}
