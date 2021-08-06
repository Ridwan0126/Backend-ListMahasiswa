package com.controller;


import com.exception.NotFoundException;
import com.model.User;
import com.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RestController
@RequestMapping("/RestAPI/")
public class UsersController {
    @Autowired
    private UserRepo userRepo;

    // Get All Data User
    @GetMapping("/User")
    public List<User> getAllUser(){return userRepo.findAll();}

    //Create User
    @PostMapping("/User")
    public User createUser(@RequestBody User user){return userRepo.save(user);}

    // Get User By Id
    @GetMapping("/User/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User user = userRepo.findById(id).orElseThrow(() -> new NotFoundException("User Is Not Exits With ID :" + id));
        return ResponseEntity.ok(user);
    }

    //update users data
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUsers(@PathVariable Long id, @RequestBody User usersDetail){
        User users = userRepo.findById(id)
                .orElseThrow(()-> new NotFoundException("User is not exits with id :" + id));

        users.setFullname(usersDetail.getFullname());
        users.setUsername(usersDetail.getUsername());
        users.setEmail(usersDetail.getEmail());
        users.setPassword(usersDetail.getPassword());

        User updateUsers = userRepo.save(users);
        return ResponseEntity.ok(updateUsers);
    }

    //delete users
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUsers(@PathVariable Long id){
        User users = userRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("User not exist with id :"+ id));
        userRepo.delete(users);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
