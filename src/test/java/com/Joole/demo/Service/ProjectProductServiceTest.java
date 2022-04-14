package com.Joole.demo.Service;

import com.Joole.demo.Entity.Product;
import com.Joole.demo.Entity.Project;
import com.Joole.demo.Entity.ProjectProduct;
import com.Joole.demo.Repository.ProjectProductRepository;
import com.Joole.demo.Service.impl.ProductServiceImp;
import com.Joole.demo.Service.impl.ProjectProductServiceImp;
import com.Joole.demo.Service.impl.ProjectServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class ProjectProductServiceTest {
    @Autowired
    ProjectProductServiceImp projectProductService;
    @Autowired
    ProjectProductRepository projectProductRepository;
    @Autowired
    ProjectServiceImp projectService;
    @Autowired
    ProductServiceImp productService;

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
        this.testProduct = new Product(
                1990L,
                "no brand",
                "Not certificated",
                LocalDateTime.now(),
                LocalDateTime.of(2000, 1, 1, 0, 0)
        );

        this.testprojectProduct = new ProjectProduct();
        testprojectProduct.setProject(testProject);
        testprojectProduct.setProduct(testProduct);
        projectService.create(testProject);
        productService.create(testProduct);
    }

    @Test
    void create() {
        projectProductService.create(testprojectProduct);
        Assertions.assertEquals(testProject.getProjectId(), testprojectProduct.getProject().getProjectId());
    }

    @Test
    void findByOneId() {
        projectProductService.create(testprojectProduct);
        Assertions.assertEquals(projectProductService.findByOneId(testprojectProduct.getPRid()).getProduct().getResourceId(),
                testprojectProduct.getProduct().getResourceId());
    }

    @Test
    void readAll() {
        projectProductService.create(testprojectProduct);
        ProjectProduct testprojectProduct2 = new ProjectProduct();
        projectProductService.create(testprojectProduct2);
        Assertions.assertTrue(projectProductService.readAll().size() >= 2);
    }

    @Test
    void deleteByProjectAndProduct() {

    }
}