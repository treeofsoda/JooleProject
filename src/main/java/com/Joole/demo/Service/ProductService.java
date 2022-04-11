package com.Joole.demo.Service;

import com.Joole.demo.Entity.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductService {

    @Transactional
    Product Create();

    Product findByOneId(Long id);

    List<Product> readAll();

    Product Update(Product product);

    void Delete(Long id);
}
