package com.wasif.springbootmicroservice.controllers;

import com.wasif.springbootmicroservice.entities.User;
import com.wasif.springbootmicroservice.exceptions.ResourceNotFoundException;
import com.wasif.springbootmicroservice.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //GET all users
    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    //GET  user by id
    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        User user = userService.getById(id);
        if (user == null) {
            throw new ResourceNotFoundException("No data available!");
        }
        return user;
    }

    //Add a user
    @PostMapping
    public ResponseEntity<Object> add(@RequestBody User user) {
        User newUser = userService.add(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    //delete a user
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        userService.delete(id);
    }

}
