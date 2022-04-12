package com.Joole.demo.Service;

import com.Joole.demo.Entity.Project;
import com.Joole.demo.Entity.ProjectProduct;
import com.Joole.demo.Entity.ProjectProductId;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProjectProductService {

    @Transactional
    ProjectProduct create(ProjectProduct projectProduct);

    ProjectProduct findByOneId(ProjectProductId id);

    List<ProjectProduct> readAll();

    ProjectProduct update(ProjectProduct projectProduct);

    void delete(ProjectProductId id);
}
