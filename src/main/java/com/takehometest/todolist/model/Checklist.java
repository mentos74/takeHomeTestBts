package com.takehometest.todolist.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "checklist")
public class Checklist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private boolean completed;

}
