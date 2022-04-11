package com.Joole.demo.Service;

import com.Joole.demo.Entity.Project;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProjectService {
    @Transactional
    Project create(Project project);

    Project findByOneId(int id);

    List<Project> readAll();

    Project update(Project project);

    void delete(int id);
}
