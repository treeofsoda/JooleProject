package com.Joole.demo.Service;

import com.Joole.demo.Entity.Product;
import com.Joole.demo.Entity.Project;
import com.Joole.demo.Entity.ProjectProduct;
import com.Joole.demo.Repository.ProjectProductRepository;
import com.Joole.demo.Service.impl.ProjectProductServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class ProjectProductServiceTest {
    @Autowired
    ProjectProductServiceImp projectProductServiceImp;
    @Autowired
    ProjectProductRepository projectProductRepository;

    private Project testProject;
    private Product testProduct;
    private ProjectProduct testprojectProduct;
    // private ProjectProductId testPRid;
    @BeforeEach
    public void setup() {
        this.testProject = new Project(
                LocalDateTime.now(),
                LocalDateTime.of(2000, 1, 1, 0, 0)
        );
        testProject.setProject_id(19903445);

        this.testProduct = new Product(
                1990L,
                "no brand",
                "Not certificated",
                LocalDateTime.now(),
                LocalDateTime.of(2000, 1, 1, 0, 0)
        );
        testProduct.setResource_id(199034);


        this.testprojectProduct = new ProjectProduct();
        testprojectProduct.setProject(testProject);
        testprojectProduct.setProduct(testProduct);
        testprojectProduct.setPRid(123455);
    }
    @Test
    void create() {
        projectProductServiceImp.create(testprojectProduct);
        Assertions.assertEquals(199034, testprojectProduct.getProduct().getResource_id());
    }

    @Test
    void findByOneId() {

    }

    @Test
    void readAll() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}