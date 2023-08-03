package com.example.authDemo.repository;

import com.example.authDemo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,String> {
    User findByEmailAndPassword(String email, String password);
}
