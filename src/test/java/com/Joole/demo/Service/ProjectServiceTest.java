package com.Joole.demo.Service;

import com.Joole.demo.Entity.Product;
import com.Joole.demo.Entity.Project;
import com.Joole.demo.Repository.ProjectRepository;
import com.Joole.demo.Service.impl.ProjectServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class ProjectServiceTest {
    @Autowired
    private ProjectServiceImp projectServiceImp;
    @Autowired
    private ProjectRepository projectRepository;

    private Project testProject;
    @BeforeEach
    public void setup() {
        this.testProject = new Project(
                LocalDateTime.now(),
                LocalDateTime.of(2000, 1, 1, 0, 0)
        );
        testProject.setProject_id(1990123);
    }

    @Test
    void create() {
        projectServiceImp.create(testProject);
        Assertions.assertEquals(testProject.getLast_updated(),
                projectServiceImp.findByOneId(1990123).getLast_updated());
    }

    @Test
    void findByOneId() {
        testProject.setProject_id(1991456);
        testProject.setLast_updated(LocalDateTime.now());
        projectServiceImp.create(testProject);
        Assertions.assertNotEquals(projectServiceImp.findByOneId(1990123).getLast_updated(),
                projectServiceImp.findByOneId(1991456).getLast_updated());
    }

    @Test
    void readAll() {
        projectServiceImp.create(testProject);
        List<Project> projectList = projectServiceImp.readAll();
        Assertions.assertNotEquals(0, projectList.size());
    }

    @Test
    void update() {
        projectServiceImp.create(testProject);
        LocalDateTime oldTime = testProject.getLast_updated();
        testProject.setLast_updated(LocalDateTime.now());
        projectServiceImp.update(testProject);
        Assertions.assertNotEquals(oldTime,
                projectServiceImp.findByOneId(1990123).getLast_updated());
    }

    @Test
    void delete() {
        projectServiceImp.create(testProject);
        projectServiceImp.delete(testProject.getProject_id());
        Assertions.assertEquals(null, projectServiceImp.findByOneId(1990123));
    }
}