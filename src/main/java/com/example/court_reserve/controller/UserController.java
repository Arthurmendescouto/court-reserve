package com.example.court_reserve.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.court_reserve.controller.request.UserRequest;
import com.example.court_reserve.controller.response.UserResponse;
import com.example.court_reserve.entity.User;
import com.example.court_reserve.mapper.UserMapper;
import com.example.court_reserve.service.UserService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;

import io.swagger.v3.oas.annotations.security.SecurityScheme;

@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer"
)
@SecurityRequirement(name = "bearerAuth")
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
    @PatchMapping("/{id}/password")
    public ResponseEntity<Void> updatePassword(@PathVariable Long id, @RequestBody UserRequest request) {
        userService.updatePassword(id, request);
        return ResponseEntity.noContent().build();
    }
}
