package com.Joole.demo.Repository;

import com.Joole.demo.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository
    extends JpaRepository<Product, Integer> {
}
