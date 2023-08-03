package com.example.authDemo.controller;

import com.example.authDemo.domain.User;
import com.example.authDemo.service.TokenGeneratorImpl;
import com.example.authDemo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/v1")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    TokenGeneratorImpl tokenGenerator;

    //http://localhost:4444/api/user/v1/register
    @PostMapping("/register")
    public ResponseEntity<?>registerUser(@RequestBody User user)
    {
        if(user.getRole()==null)
        {
            user.setRole("role-user");
        }
        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
    }

    //http://localhost:4444/api/user/v1/login
    @GetMapping("login")
    public ResponseEntity<?>checkLogin(@RequestBody User user)
    {
        User validation = userService.checkLogin(user);
        if (validation != null)
        {
            return new ResponseEntity<>(tokenGenerator.generateToken(user),HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Authentication Failed!",HttpStatus.EXPECTATION_FAILED);
        }
    }
}
