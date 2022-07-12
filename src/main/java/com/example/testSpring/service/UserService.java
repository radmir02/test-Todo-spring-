package com.example.testSpring.service;

import com.example.testSpring.entity.UserEntity;
import com.example.testSpring.exeption.UserAlreadyExsistException;
import com.example.testSpring.exeption.UserNotFoundException;
import com.example.testSpring.model.User;
import com.example.testSpring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration (UserEntity user) throws UserAlreadyExsistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExsistException("Пользователь с таким именем уже существует");
        }
        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if(user == null)
            throw new UserNotFoundException("Пользователь не найден");
        return User.toModel(user);
    }

    public Long delete (Long id){
        userRepo.deleteById(id);
        return id;
    }
}

