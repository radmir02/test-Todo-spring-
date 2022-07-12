package com.example.testSpring.service;

import com.example.testSpring.entity.TodoEntity;
import com.example.testSpring.entity.UserEntity;
import com.example.testSpring.model.Todo;
import com.example.testSpring.repository.TodoRepo;
import com.example.testSpring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userId){
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));
    }
    public Todo completeTodo(Long id){
        TodoEntity todoEntity = todoRepo.findById(id).get();
        todoEntity.setCompleted(!todoEntity.getCompleted());
        return Todo.toModel(todoRepo.save(todoEntity));
    }
}
