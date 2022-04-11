package com.Joole.demo.Service;

import com.Joole.demo.Entity.Project;
import com.Joole.demo.Entity.ProjectProduct;

public interface ProjectProductService {
    ProjectProduct Create();

    ProjectProduct findByOneId(Long id);

    String readAll();

    ProjectProduct Update(ProjectProduct projectProduct);

    void Delete(Long id);
}
