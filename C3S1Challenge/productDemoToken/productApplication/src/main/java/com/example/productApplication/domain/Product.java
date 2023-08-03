package com.example.productApplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    String productName;
    int productPrice;
}
