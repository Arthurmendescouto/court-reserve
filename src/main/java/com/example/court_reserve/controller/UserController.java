package com.example.court_reserve.controller;

import com.example.court_reserve.controller.request.CourtRequest;
import com.example.court_reserve.controller.request.UserRequest;
import com.example.court_reserve.controller.response.CourtResponse;
import com.example.court_reserve.controller.response.UserResponse;
import com.example.court_reserve.entity.Court;
import com.example.court_reserve.entity.User;
import com.example.court_reserve.mapper.CourtMapper;
import com.example.court_reserve.mapper.UserMapper;
import com.example.court_reserve.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/court_reserve/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        List<UserResponse> users=userService.findAll()
                .stream()
                .map(user -> UserMapper.toUserResponse(user))
                .toList();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id){
        return userService.findById(id)
                .map(user -> ResponseEntity.ok(UserMapper.toUserResponse(user)))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<UserResponse> saveUser(@RequestBody UserRequest request){
        User newUser= UserMapper.toUser(request);
        User savedUser=userService.save(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse(savedUser));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByUserId(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
