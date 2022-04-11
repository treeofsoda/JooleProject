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
    public Product Create(){
        Product product = new Product(
                1990L,
                "no brand",
                "Not certificated",
                LocalDateTime.now(),
                LocalDateTime.of(2000, 1, 1, 0, 0)
        );
        product.setResource_id(145L);
        productRepository.save(product);
        return product;
    }


    @Override
    public Product findByOneId(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> readAll(){
        List<Product> list = (List<Product>) productRepository.findAll();
        return list;
    }

    @Override
    public Product Update(Product product) {
        return productRepository.save(product);
    }


    @Override
    public void Delete(Long id) {
        productRepository.deleteById(id);
    }
}
