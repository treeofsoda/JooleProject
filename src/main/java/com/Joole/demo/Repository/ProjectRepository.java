package com.Joole.demo.Repository;

import com.Joole.demo.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository
        extends JpaRepository<Project, Integer> {


}
