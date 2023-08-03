package com.example.productApplication.service;

import com.example.productApplication.domain.User;

import java.util.List;

public interface IProductService {
    User saveDetails(User user);
    User getUsers(String email);
    boolean deleteUser(String email);
    List<User> getAllUsersByAdmin();

}
