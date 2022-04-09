package com.Joole.demo.Service.impl;

import com.Joole.demo.Repository.ProjectRepository;
import com.Joole.demo.Service.ProjectSerivce;
import com.Joole.demo.Entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectServicelmp implements ProjectSerivce{
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    @Transactional
    public Project Create(){
        Project project = new Project();
        projectRepository.save(project);
        return project;
    }


    @Override
    public Project findByOneId(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public String readAll(){
        StringBuilder sb = new StringBuilder();
        List<Project> list = (List<Project>) projectRepository.findAll();
        for(Project p : list){
            sb.append(p.toString());
        }
        return sb.toString();
    }

    @Override
    public Project Update(Project project) {
        return projectRepository.save(project);
    }


    @Override
    public void Delete(Long id) {
        projectRepository.deleteById(id);
    }
}
