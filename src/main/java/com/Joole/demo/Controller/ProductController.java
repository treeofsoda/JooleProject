package com.Joole.demo.Controller;

import com.Joole.demo.Entity.Product;
import com.Joole.demo.Entity.Project;
import com.Joole.demo.Service.ProductService;
import com.Joole.demo.Service.ProjectSerivce;
import com.Joole.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/Create")
    public Product Create() {
        return productService.Create();
    }

    @GetMapping("/findOne")
    public Product findByUsername(@RequestParam("resource_id") Long id){
        return productService.findByOneId(id);
    }

    @GetMapping("/ReadAll")
    public String readAll(){
        return productService.readAll();
    }

    @PostMapping("/Update")
    public Product Update(@RequestBody Product product){
        return productService.Update(product);
    }

    @DeleteMapping("/Delete")
    public void Delete(@RequestParam("resource_id") Long id){
        productService.Delete(id);
    }
}
