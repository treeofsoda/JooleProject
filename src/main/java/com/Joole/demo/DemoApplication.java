package com.Joole.demo;

import com.Joole.demo.Entity.Product;
import com.Joole.demo.Repository.ProductRepository;
import com.Joole.demo.Service.ProductService;
import com.Joole.demo.Service.impl.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
