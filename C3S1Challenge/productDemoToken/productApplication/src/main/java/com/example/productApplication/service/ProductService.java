package com.example.productApplication.service;

import com.example.productApplication.domain.User;
import com.example.productApplication.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService{
    @Autowired
    IProductRepository iProductRepository;
    @Override
    public User saveDetails(User user) {
        return iProductRepository.save(user);
    }

    @Override
    public User getUsers(String email) {
        return iProductRepository.findById(email).get();
    }

    @Override
    public boolean deleteUser(String email) {
        if(iProductRepository.findById(email).isPresent())
        {
            iProductRepository.deleteById(email);
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public List<User> getAllUsersByAdmin() {
        return iProductRepository.findAll();
    }
}
