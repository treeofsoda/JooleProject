package com.Joole.demo.Repository;

import com.Joole.demo.Entity.ProjectProduct;
import com.Joole.demo.Entity.ProjectProductId;
import org.springframework.data.repository.CrudRepository;

public interface Project_ProductRepository
        extends CrudRepository<ProjectProduct, ProjectProductId> {

}
