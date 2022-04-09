package com.Joole.demo.Service;

import com.Joole.demo.Entity.Project;
import org.springframework.transaction.annotation.Transactional;

public interface ProjectSerivce {
    @Transactional
    Project Create();

    Project findByOneId(Long id);

    String readAll();

    Project Update(Project project);

    void Delete(Long id);
}
