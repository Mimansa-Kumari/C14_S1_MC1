package com.example.authDemo.service;

import com.example.authDemo.domain.User;

import java.util.Map;

public interface ITokenGenerator {
    Map<String,String> generateToken(User user);
}
