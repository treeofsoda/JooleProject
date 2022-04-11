package com.Joole.demo.Service.impl;

import com.Joole.demo.Entity.Product;
import com.Joole.demo.Repository.ProjectRepository;
import com.Joole.demo.Service.ProjectService;
import com.Joole.demo.Entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectServicelmp implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    @Transactional
    public Project create(Project project){
        return projectRepository.save(project);
    }


    @Override
    public Project findByOneId(int id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public List<Project> readAll(){
        List<Project> list = projectRepository.findAll();
        return list;
    }

    @Override
    public Project update(Project project) {
        return projectRepository.save(project);
    }


    @Override
    public void delete(int id) {
        projectRepository.deleteById(id);
    }
}
