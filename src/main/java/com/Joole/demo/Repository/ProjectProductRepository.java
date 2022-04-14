package com.Joole.demo.Repository;

import com.Joole.demo.Entity.ProjectProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectProductRepository
        extends JpaRepository<ProjectProduct, Integer> {

}
