package com.takehometest.todolist.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneralResponse<T> {
    private int status;
    private String message;
    private T data;
}