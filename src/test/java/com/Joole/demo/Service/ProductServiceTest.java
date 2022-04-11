package com.Joole.demo.Service;

import com.Joole.demo.Entity.Product;
import com.Joole.demo.Service.impl.ProductServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductServiceImp productServiceImp;

    @Test
    public void Create() {
        productServiceImp.Create();
    }
}