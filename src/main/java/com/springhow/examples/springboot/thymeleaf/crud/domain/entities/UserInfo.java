package com.springhow.examples.springboot.thymeleaf.crud.domain.entities;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserInfo {
    private Integer id;
    private String firstName;
    private String lastName;
    private Role role;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
    private Boolean willDelete;
}