package com.Joole.demo.Repository;

import com.Joole.demo.Entity.Product;
import com.Joole.demo.Entity.Project;
import com.Joole.demo.Entity.ProjectProduct;
import com.Joole.demo.Service.impl.ProductServiceImp;
import com.Joole.demo.Service.impl.ProjectProductServiceImp;
import com.Joole.demo.Service.impl.ProjectServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProjectProductRepositoryTest {
    @Autowired
    ProjectProductRepository projectProductRepository;
//    @Autowired
//    ProjectRepository projectRepository;
//    @Autowired
//    ProductRepository productRepository;

    @Test
    void create() {
        ProjectProduct testProjectProduct = new ProjectProduct();
        projectProductRepository.save(testProjectProduct);
        Assertions.assertEquals(projectProductRepository.findById(testProjectProduct.getPRid()).get().getPRid(),
                testProjectProduct.getPRid());

    }

//    @Test
//    void deleteByProjectProduct() {
//        Project testProject = new Project();
//        Product testProduct = new Product();
//        ProjectProduct testProjectProduct = new ProjectProduct();
//        testProjectProduct.setProduct(testProduct);
//        testProjectProduct.setProject(testProject);
//        projectRepository.save(testProject);
//        productRepository.save(testProduct);
//        projectProductRepository.save(testProjectProduct);
//        projectProductRepository.deleteByProjectAndProduct(testProject, testProduct);
//        Assertions.assertEquals(Optional.empty(), projectProductRepository.findById(testProjectProduct.getPRid()));
//    }
}