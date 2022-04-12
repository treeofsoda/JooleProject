package com.Joole.demo.Controller;

import com.Joole.demo.Entity.Product;
import com.Joole.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/Product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<?> Create(@RequestParam(name = "resource_id") int resource_id) {
        Product productToAdd = new Product(resource_id);
        productToAdd.setTime_created(LocalDateTime.now());
        try {
            productService.create(productToAdd);
        } catch (Exception e) {
            return new ResponseEntity<>("{\"error\":\"something wrong happens when creating new product!\"}",
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(productToAdd,HttpStatus.CREATED);
    }

    @GetMapping("/findOne")
    public ResponseEntity<?> findByOneId(@RequestParam(name = "resource_id") int id){
        Product productToFind = productService.findByOneId(id);
        if (productToFind == null) {
            return new ResponseEntity<>("{\"error\":\"product not found!\"}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(productToFind.toString() + "is found", HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> readAll(){
        List<Product> productList;
        try {
            productList = productService.readAll();
        } catch (Exception e) {
            return new ResponseEntity<>("{\"error\":\"cannot read!\"}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(productList.toString(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> Update(@RequestBody Product productToUpdate, @RequestParam(name = "resource_id") int resource_id){

        try {
            productService.create(productToUpdate);
        } catch (Exception e) {
            return new ResponseEntity<>("{\"error\":\"something wrong happens when updating product!\"}",
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(productToUpdate,HttpStatus.OK);
    }

    @DeleteMapping("/deleteOne")
    public ResponseEntity<?> Delete(@RequestParam("resource_id") int id){
        Product productToDelete = productService.findByOneId(id);
        if (productToDelete == null) {
            return new ResponseEntity<>("{\"error\":\"product not found!\"}", HttpStatus.BAD_REQUEST);
        }
        productService.delete(id);
        return new ResponseEntity<>(productToDelete.toString() + "is deleted", HttpStatus.OK);
    }
}
