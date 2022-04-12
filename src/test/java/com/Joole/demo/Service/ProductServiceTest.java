package com.Joole.demo.Service;

import com.Joole.demo.Entity.Product;
import com.Joole.demo.Service.impl.ProductServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductServiceImp productServiceImp;

    @Test
    public void Create() {
        Product random_product1 = new Product(
                1990L,
                "no brand",
                "Not certificated",
                LocalDateTime.now(),
                LocalDateTime.of(2000, 1, 1, 0, 0)

        );
        random_product1.setResource_id(45);
        productServiceImp.create(random_product1);
    }
}