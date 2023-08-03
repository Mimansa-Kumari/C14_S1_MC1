package com.example.authDemo.service;

import com.example.authDemo.domain.User;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class TokenGeneratorImpl implements ITokenGenerator{
    @Override
    public Map<String, String> generateToken(User user) {
        Map<String,String> result = new HashMap<>();
        Map<String,Object> userData = new HashMap<>();
        userData.put("userEmail",user.getEmail());
        userData.put("userRole",user.getRole());
        String myToken = Jwts.builder()
                .setClaims(userData)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"secretKeyForWave46")
                .compact();
        result.put("Token",myToken);
        result.put("Message","User Login Successfully!");
        return result;
    }
}
