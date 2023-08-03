package com.example.authDemo.service;

import com.example.authDemo.domain.User;
import com.example.authDemo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private IUserRepository iUserRepository;
    @Override
    public User registerUser(User user) {
        return iUserRepository.save(user);
    }

    @Override
    public User checkLogin(User user) {
        return iUserRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
    }
}
