package com.Joole.demo.Service;

import com.Joole.demo.Entity.Product;
import com.Joole.demo.Repository.ProductRepository;
import com.Joole.demo.Service.impl.ProductServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductServiceImp productServiceImp;
    @Autowired
    private ProductRepository productRepository;

    private Product testProduct;
    @BeforeEach
    public void setup() {
        this.testProduct = new Product(
                1991L,
                "no brand",
                "Not certificated",
                LocalDateTime.now(),
                LocalDateTime.of(2000, 1, 1, 0, 0)
        );
        //testProduct.setResource_id(1990123);
    }
    @Test
    public void create() {
        productServiceImp.create(testProduct);
        Assertions.assertEquals(testProduct.getModelYear(),
                productServiceImp.findByOneId(testProduct.getResourceId()).getModelYear());
    }


    @Test
    void findByOneId() {
        testProduct.setLastUpdated(LocalDateTime.now());
        productServiceImp.create(testProduct);
        Assertions.assertEquals(productServiceImp.findByOneId(testProduct.getResourceId()).getLastUpdated(),
                productServiceImp.findByOneId(testProduct.getResourceId()).getLastUpdated());
    }

    @Test
    void readAll() {
        productServiceImp.create(testProduct);
        List<Product> productList = productServiceImp.readAll();
        Assertions.assertNotEquals(0, productList.size());
    }

    @Test
    void update() {
        productServiceImp.create(testProduct);
        LocalDateTime oldTime = testProduct.getLastUpdated();
        testProduct.setLastUpdated(LocalDateTime.now());
        productServiceImp.update(testProduct);
        Assertions.assertNotEquals(oldTime,
                productServiceImp.findByOneId(testProduct.getResourceId()).getLastUpdated());
    }

    @Test
    void deleteById() {
        productServiceImp.create(testProduct);
        productServiceImp.delete(testProduct.getResourceId());
        Assertions.assertEquals(null, productServiceImp.findByOneId(testProduct.getResourceId()));
    }
}