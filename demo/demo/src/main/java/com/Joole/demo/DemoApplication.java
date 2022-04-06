package com.Joole.demo;

import com.Joole.demo.Repository.ProductRepository;
import com.Joole.demo.Repository.ProjectRepository;
import com.Joole.demo.Repository.Project_ProductRepository;
import com.Joole.demo.Repository.UserRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
