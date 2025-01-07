package com.takehometest.todolist.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_app")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;


}
