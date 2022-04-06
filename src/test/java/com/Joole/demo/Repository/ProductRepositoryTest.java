package com.Joole.demo.Repository;

import com.Joole.demo.Entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    ProductRepository productRepository;

    @Test
    public void createTest() {
                Product random_product1 = new Product(
                        1990L,
                        "no brand",
                        "Not certificated",
                        LocalDateTime.now(),
                        LocalDateTime.of(2000, 1, 1, 0, 0)

                );
                random_product1.setResource_id(1990123456789L);
                productRepository.save(random_product1);
                Assertions.assertEquals(null, random_product1);
    }

}