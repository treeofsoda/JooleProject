package com.Joole.demo.Service;

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
    }

    @Test
    void create() {
        projectServiceImp.create(testProject);
        Assertions.assertEquals(testProject.getLastUpdated(),
                projectServiceImp.findByOneId(testProject.getProjectId()).getLastUpdated());
    }

    @Test
    void findByOneId() {
        testProject.setLastUpdated(LocalDateTime.now());
        projectServiceImp.create(testProject);
        Assertions.assertNotEquals(projectServiceImp.findByOneId(testProject.getProjectId()-1).getLastUpdated(),
                projectServiceImp.findByOneId(testProject.getProjectId()).getLastUpdated());
    }

    @Test
    void readAll() {
        projectServiceImp.create(testProject);
        List<Project> projectList = projectServiceImp.readAll();
        Assertions.assertEquals(projectList.size(), projectList.size());
    }

    @Test
    void update() {
        projectServiceImp.create(testProject);
        LocalDateTime oldTime = testProject.getLastUpdated();
        testProject.setLastUpdated(LocalDateTime.now());
        projectServiceImp.update(testProject);
        Assertions.assertNotEquals(oldTime,
                projectServiceImp.findByOneId(testProject.getProjectId()).getLastUpdated());
    }

    @Test
    void deleteById() {
        projectServiceImp.create(testProject);
        projectServiceImp.delete(testProject.getProjectId());
        Assertions.assertEquals(null, projectServiceImp.findByOneId(testProject.getProjectId()));
    }
}