package com.Joole.demo.Controller;

import com.Joole.demo.Entity.Product;
import com.Joole.demo.Entity.Project;
import com.Joole.demo.Entity.ProjectProduct;
import com.Joole.demo.Service.ProductService;
import com.Joole.demo.Service.ProjectProductService;
import com.Joole.demo.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/ProjectProduct")
public class ProjectProductController {
    @Autowired
    private ProjectProductService projectProductService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProductService productService;

    private ProjectProduct projectProductToAdd;
    @PostMapping("/addProduct/{resource_id}/intoProject/{project_id}")
    public ResponseEntity<?> Create(@PathVariable int resource_id, @PathVariable int project_id) {
        Project projectTemp;
        Product productTemp;
        try {
            projectTemp = projectService.findByOneId(project_id);
            productTemp = productService.findByOneId(resource_id);
            projectProductToAdd = new ProjectProduct(projectTemp, productTemp);
            projectProductService.create(projectProductToAdd);
        } catch (Exception e) {
            return new ResponseEntity<>("{\"error\":\""+e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(projectProductToAdd.toString(), HttpStatus.CREATED);
    }

//    @PostMapping("/findOne")
//    public ResponseEntity<?> findByOneId(@RequestParam ProjectProductId PRid){
//        ProjectProduct projectProductToFind = projectProductService.findByOneId(PRid);
//        if (projectProductToFind == null) {
//            return new ResponseEntity<>("{\"error\":\"ProjectProduct not found! \"}", HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>(projectProductToFind.toString() + "is found", HttpStatus.OK);
//    }

    @GetMapping("/findAll")
    public ResponseEntity<?> readAll(){
        List<ProjectProduct> projectProductList;
        try {
            projectProductList = projectProductService.readAll();
        } catch (Exception e) {
            return new ResponseEntity<>("{\"error\":\"cannot read!\"}", HttpStatus.BAD_REQUEST);
        }
        String returnString = "[";
        for (ProjectProduct pp:projectProductList) {
            returnString += "\n";
            returnString += pp.toString();
        }
        returnString += "\n]";
        return new ResponseEntity<>(returnString.toString(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> Update(@RequestBody ProjectProduct projectProductToUpdate){
        try {
            projectProductService.create(projectProductToUpdate);
        } catch (Exception e) {
            return new ResponseEntity<>("{\"error\":\"something wrong happens when updating projectproduct!\"}",
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(projectProductToUpdate,HttpStatus.OK);
    }

    @DeleteMapping("/deleteOne")
    public ResponseEntity<?> Delete(@RequestParam("PRid") int PRid){
        ProjectProduct projectProductDelete = projectProductService.findByOneId(PRid);
        if (projectProductDelete == null) {
            return new ResponseEntity<>("{\"error\":\"projectproduct not found!\"}", HttpStatus.BAD_REQUEST);
        }
        projectProductService.delete(PRid);
        return new ResponseEntity<>(projectProductDelete.toString() + "is deleted", HttpStatus.OK);
    }
}