package com.g_29.restWebservice.restful_web_service.controller;

import com.g_29.restWebservice.restful_web_service.Service.UserService;
import com.g_29.restWebservice.restful_web_service.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService service;


    @GetMapping("/users")
    public ResponseEntity<List<User>> retrieveAllUsers() {
        List<User> users = service.findAll();
        return ResponseEntity.ok(users);
    }


    @GetMapping("/users/{id}")
    public ResponseEntity<Optional<User>> retrieveUserById(@PathVariable int id) {
        Optional<User> user = service.findUserById(id);
//        EntityModel<User>entityModel=EntityModel.of(user);
//
//        WebMvcLinkBuilder link=WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
//        entityModel.add(link.withRel("all-users"));

        return ResponseEntity.status(200).body(user);

    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = service.addUser(user);
        return ResponseEntity.status(201).body(savedUser);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        boolean deleted = service.deleteUser(id);
        if (!deleted) {
            return ResponseEntity.status(404).body("User not found with id: " + id);
        }
        return ResponseEntity.ok("The user with id: " + id + " is deleted");
    }
}
