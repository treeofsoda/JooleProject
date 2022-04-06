package com.Joole.demo.Repository;

import com.Joole.demo.Entity.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository
        extends CrudRepository<Project, Long> {
}
