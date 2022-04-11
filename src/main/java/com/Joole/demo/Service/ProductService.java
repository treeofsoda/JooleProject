package com.Joole.demo.Service;

import com.Joole.demo.Entity.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductService {

    //@Transactional
    Product create(Product product);

    Product findByOneId(int id);

    List<Product> readAll();

    Product update(Product product);

    void delete(int id);
}
