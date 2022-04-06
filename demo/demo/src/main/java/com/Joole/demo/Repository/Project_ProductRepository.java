package com.Joole.demo.Repository;

import com.Joole.demo.Entity.Project_Product;
import com.Joole.demo.Entity.Project_ProductId;
import org.springframework.data.repository.CrudRepository;

public interface Project_ProductRepository
        extends CrudRepository<Project_Product, Project_ProductId> {

}
