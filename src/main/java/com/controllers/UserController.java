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
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository repository;

    // Get Find all
    @GetMapping
    public ResponseEntity getall(){
        List<User> listUsers = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listUsers);
    }

    // Get by ID
    @GetMapping("/{id}")
    public ResponseEntity getByID(@PathVariable Integer id){
        var listUserbyID = repository.findById(id);
        if(listUserbyID.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Has no user by this ID");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(listUserbyID);
    }

    // Post
    @PostMapping
    public ResponseEntity saveUser(@RequestBody UserDto dto){
        var user = new User();
        BeanUtils.copyProperties(dto, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(user));
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("this user was deleted");
    }

    // Update
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
