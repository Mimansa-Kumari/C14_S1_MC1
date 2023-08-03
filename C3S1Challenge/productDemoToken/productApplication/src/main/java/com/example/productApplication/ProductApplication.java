package com.example.productApplication;

import com.example.productApplication.filter.ProductFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean filterRegister()
	{
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new ProductFilter());
		filterRegistrationBean.addUrlPatterns("/api/product/v1/getUsers","/api/product/v1/admin/getAllUsers");
		return filterRegistrationBean;
	}
}
