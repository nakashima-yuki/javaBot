package com.example.bot.service;

import com.example.bot.model.User;

public interface UserService {
    User findById(Integer id);

    User findByEmail(String email);

    void regiser(String email, String password);
}
