package com.stage.userCrud.controller;

import com.stage.userCrud.model.User;
import com.stage.userCrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/users")
    public ResponseEntity<List<User>> get(){

        List<User> users = userService.FindAll();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
    @PostMapping("/users")
    public ResponseEntity<User> save(@RequestBody User user){

        User userOne = userService.save(user);
        return new ResponseEntity<User>(userOne, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> get(@PathVariable("id") Long id){

        User user = userService.findById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){

        userService.deleteUser(id);
        return new ResponseEntity<String>("User is deleted successfully", HttpStatus.OK);
    }
}
