package com.example.productApplication.controller;

import com.example.productApplication.domain.User;
import com.example.productApplication.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/product/v1")
public class ProductController {
    @Autowired
    IProductService iProductService;

    //http://localhost:7777/api/product/v1/addUser
    @PostMapping("/addUser")
    public ResponseEntity<?>saveDetails(@RequestBody User user)
    {
        User user1 = iProductService.saveDetails(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    //http://localhost:7777/api/product/v1/getUsers
    @GetMapping("/getUsers")
    public ResponseEntity<?>getUsers(HttpServletRequest httpServletRequest)
    {
        String email = (String) httpServletRequest.getAttribute("attr1");
        return new ResponseEntity<>(iProductService.getUsers(email),HttpStatus.OK);
    }

    //http://localhost:7777/api/product/v1/delBy/mim@gmail.com
    @DeleteMapping("/delBy/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable String email)
    {
        return new ResponseEntity<>(iProductService.deleteUser(email),HttpStatus.OK);
    }

    //http://localhost:7777/api/product/v1/admin/getAllUsers
    @GetMapping("/admin/getAllUsers")
    public ResponseEntity<?>getAllUsersByAdmin(HttpServletRequest httpServletRequest)
    {
        if(httpServletRequest.getAttribute("attr2").equals("role-admin"))
        {
            return new ResponseEntity<>(iProductService.getAllUsersByAdmin(),HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("You are not Authorized User!!!",HttpStatus.BAD_REQUEST);
        }
    }
}
