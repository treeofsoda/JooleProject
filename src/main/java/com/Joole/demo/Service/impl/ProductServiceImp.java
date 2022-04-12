package com.Joole.demo.Service.impl;

import com.Joole.demo.Entity.Product;
import com.Joole.demo.Repository.ProductRepository;
import com.Joole.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public Product create(Product product){ return productRepository.save(product); }

    @Override
    public Product findByOneId(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> readAll(){
        List<Product> list = (List<Product>) productRepository.findAll();
        return list;
    }

    @Override
    @Transactional
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public void delete(int id) {
        productRepository.deleteById(id);
    }
}
