package com.Joole.demo.Repository;

import com.Joole.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository
        extends JpaRepository<User, String> {
}
