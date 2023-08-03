package com.example.authDemo.service;

import com.example.authDemo.domain.User;

public interface IUserService {
    User registerUser(User user);
    User checkLogin(User user);
}
