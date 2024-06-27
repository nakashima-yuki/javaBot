package com.example.bot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private String id;
    private String name;
    @JsonIgnore
    private String password;
    private String email;
    @JsonIgnore
    private String salt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
