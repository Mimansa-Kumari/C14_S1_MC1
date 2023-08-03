package com.example.productApplication.repository;

import com.example.productApplication.domain.Product;
import com.example.productApplication.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends MongoRepository<User,String> {

}
