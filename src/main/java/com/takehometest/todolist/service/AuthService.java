package com.takehometest.todolist.service;

import com.takehometest.todolist.model.User;
import com.takehometest.todolist.dto.GeneralResponse;
import com.takehometest.todolist.repository.UserRepository;
import com.takehometest.todolist.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public User register(String username, String email, String password) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }

    public GeneralResponse<Object> login(String username, String password) {

        Optional<User> user = userRepository.findByUsername(username);
        if (!user.isPresent()) {
            return new GeneralResponse<>(103, "Username atau password salah", null);
        }

        if (!passwordEncoder.matches(password, user.get().getPassword())) {
            return new GeneralResponse<>(103, "Username atau password salah", null);
        }

        String token = jwtUtil.generateToken(username);
        System.out.println(token);
        return new GeneralResponse<>(0, "Login Sukses", token);
    }

}
