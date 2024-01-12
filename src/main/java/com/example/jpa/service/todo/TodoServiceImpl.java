package com.example.jpa.service.todo;

import com.example.jpa.domain.todo.Todo;
import com.example.jpa.domain.todo.TodoRepository;
import com.example.jpa.exception.CusNotFoundException;
import com.example.jpa.payload.todo.TodoMainRes;
import com.example.jpa.payload.todo.TodoRequest;
import com.example.jpa.payload.todo.TodoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    @Override
    public void createTodo(TodoRequest payload) {
        var entity = todoMapper.mapTodoEntity(payload);
        todoRepository.save(entity);
    }

    @Override
    public Object getAllTodo() {
        var todoList = todoRepository.findAll();
        List<TodoResponse> todoResponses = todoList.stream()
                .map(todoMapper::mapToResponse)
                .collect(Collectors.toList());
        return new TodoMainRes(todoResponses);
    }

    @Override
    public Object getById(Long id) {
        return todoRepository.findById(id)
                .map(todoMapper::mapToResponse)
                .orElseThrow(() -> new CusNotFoundException("Todo Not Found"));
    }

    @Override
    public Object updateTodo(Long id, TodoRequest payload) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new CusNotFoundException("Todo Not Found"));
        todoMapper.updateEntity(todo, payload);
        return todoRepository.save(todo);

    }

    @Override
    public void deleteById(Long id) {
        todoRepository.deleteById(id);
    }


}
