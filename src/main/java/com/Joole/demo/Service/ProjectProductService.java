package com.Joole.demo.Service;

import com.Joole.demo.Entity.ProjectProduct;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProjectProductService {

    @Transactional
    ProjectProduct create(ProjectProduct projectProduct);

    ProjectProduct findByOneId(int id);

    List<ProjectProduct> readAll();

    void delete(int id);
}
