package com.controllers;

import com.dtos.UserDto;
import com.model.User;
import com.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository repository;

    @GetMapping
    public ResponseEntity getall(){
        List<User> listUsers = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listUsers);
    }

    @PostMapping
    public ResponseEntity saveUser(@RequestBody UserDto dto){
        var user = new User();
        BeanUtils.copyProperties(dto, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@RequestBody UserDto dto){
        var user = repository.findById(id).orElse(null);
        if(user == null){
            return ResponseEntity.noContent().build();
        }
        BeanUtils.copyProperties(dto,user);
        return ResponseEntity.ok(repository.save(user));
    }


}
