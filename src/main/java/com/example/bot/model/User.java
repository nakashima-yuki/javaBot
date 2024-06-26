package com.example.bot.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private String id;
    private String name;
    private String email;
    private String salt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
