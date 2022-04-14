package com.Joole.demo.Service.impl;

import com.Joole.demo.Entity.ProjectProduct;
import com.Joole.demo.Repository.ProjectProductRepository;
import com.Joole.demo.Service.ProjectProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectProductServiceImp implements ProjectProductService {
    @Autowired
    private ProjectProductRepository projectProductRepository;

    @Override
    @Transactional
    public ProjectProduct create(ProjectProduct projectProduct){
        return projectProductRepository.save(projectProduct);
    }


    @Override
    public ProjectProduct findByOneId(int id) {
        return projectProductRepository.findById(id).orElse(null);
    }

    @Override
    public List<ProjectProduct> readAll(){
        List<ProjectProduct> list = projectProductRepository.findAll();
        return list;
    }

    @Override
    @Transactional
    public void delete(int id) {
        projectProductRepository.deleteById(id);
    }
}
