package com.Joole.demo.Controller;

import com.Joole.demo.Entity.Product;
import com.Joole.demo.Entity.Project;
import com.Joole.demo.Service.ProductService;
import com.Joole.demo.Service.ProjectSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Product")
public class ProductController {
    @Autowired
    private ProductService productService;

//    @GetMapping("/Create")
//    public Product Create() {
//        return productService.Create();
//    }
//
//    @PostMapping("/findOne")
//    public Product findByUsername(@RequestParam("resource_id") Long id){
//        return productService.findByOneId(id);
//    }

    @GetMapping
    public List<Product> readAll(){
        return productService.readAll();
    }

//    @RequestMapping("/Update")
//    public Product Update(@RequestBody Product product){
//        return productService.Update(product);
//    }
//
//    @RequestMapping("/Delete")
//    public void Delete(@RequestParam("resource_id") Long id){
//        productService.Delete(id);
//    }
}
