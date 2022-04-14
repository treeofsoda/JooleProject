package com.Joole.demo.Repository;

import com.Joole.demo.Entity.ProjectProduct;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProjectProductRepositoryTest {
    @Autowired
    ProjectProductRepository projectProductRepository;

    @Test
    void create() {
        ProjectProduct testProjectProduct = new ProjectProduct();
        testProjectProduct.setPRid(1234);
        System.out.println(testProjectProduct.getPRid());
        projectProductRepository.save(testProjectProduct);
    }
}