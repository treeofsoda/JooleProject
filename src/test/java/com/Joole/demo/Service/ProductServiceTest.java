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
        testProduct.setResource_id(1990123);
    }
    @Test
    public void create() {
        productServiceImp.create(testProduct);
        Assertions.assertEquals(testProduct.getModel_year(),
                productServiceImp.findByOneId(1990123).getModel_year());
    }


    @Test
    void findByOneId() {
        testProduct.setResource_id(1991456);
        testProduct.setLast_updated(LocalDateTime.now());
        productServiceImp.create(testProduct);
        Assertions.assertNotEquals(productServiceImp.findByOneId(1990123).getLast_updated(),
                productServiceImp.findByOneId(1991456).getLast_updated());
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
        LocalDateTime oldTime = testProduct.getLast_updated();
        testProduct.setLast_updated(LocalDateTime.now());
        productServiceImp.update(testProduct);
        Assertions.assertNotEquals(oldTime,
                productServiceImp.findByOneId(1990123).getLast_updated());
    }

    @Test
    void delete() {
        productServiceImp.create(testProduct);
        productServiceImp.delete(testProduct.getResource_id());
        Assertions.assertEquals(null, productServiceImp.findByOneId(1990123));
    }
}