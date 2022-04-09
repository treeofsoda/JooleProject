package com.Joole.demo.Service.impl;

import com.Joole.demo.Entity.Product;
import com.Joole.demo.Repository.ProductRepository;
import com.Joole.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public Product Create(){
        Product product = new Product();
        productRepository.save(product);
        return product;
    }


    @Override
    public Product findByOneId(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public String readAll(){
        StringBuilder sb = new StringBuilder();
        List<Product> list = (List<Product>) productRepository.findAll();
        for(Product p : list){
            sb.append(p.toString());
        }
        return sb.toString();
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
