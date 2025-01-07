package com.takehometest.todolist.controller;

import com.takehometest.todolist.dto.GeneralResponse;
import com.takehometest.todolist.dto.LoginRequestDTO;
import com.takehometest.todolist.model.User;
import com.takehometest.todolist.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        User registeredUser = authService.register(user.getUsername(), user.getEmail(), user.getPassword());
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public GeneralResponse<Object> login(@RequestBody LoginRequestDTO loginRequest) {
        return authService.login(loginRequest.getUsername(), loginRequest.getPassword());
    }


}
