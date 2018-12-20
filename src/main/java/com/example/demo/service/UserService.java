package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.service.response.LoginResponse;

public interface UserService {
    LoginResponse login(User user);
    LoginResponse register(User user);
}
