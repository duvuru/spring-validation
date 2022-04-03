package com.ragainfotech.validation.controller;

import com.ragainfotech.validation.dto.UserRequest;
import com.ragainfotech.validation.entity.User;
import com.ragainfotech.validation.exception.UserNotFoundException;
import com.ragainfotech.validation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest){
        return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);
    }
    @GetMapping("/retrieveAllUsers")
    public ResponseEntity<List<User>> getAllUsers(){
       return  ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(userService.getUser(id));
    }
}
