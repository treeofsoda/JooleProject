package com.Joole.demo.Repository;

import com.Joole.demo.Entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository
    extends CrudRepository<Product, Long> {
}
