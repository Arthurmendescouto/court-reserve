package com.example.court_reserve.controller;

import com.example.court_reserve.config.TokenService;
import com.example.court_reserve.controller.request.LoginRequest;
import com.example.court_reserve.controller.request.UserRequest;
import com.example.court_reserve.controller.response.LoginResponse;
import com.example.court_reserve.controller.response.UserResponse;
import com.example.court_reserve.entity.User;
import com.example.court_reserve.mapper.UserMapper;
import com.example.court_reserve.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/court_reserve/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest request){
    User savedUser=userService.save(UserMapper.toUser(request));
    return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse(savedUser));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        UsernamePasswordAuthenticationToken userAndPass=new UsernamePasswordAuthenticationToken(request.email(),request.password());
        Authentication authenticate=authenticationManager.authenticate(userAndPass);

        User user =(User)authenticate.getPrincipal();

        String token=tokenService.generateToken(user);

        return ResponseEntity.ok(new LoginResponse(token));
    }

}
