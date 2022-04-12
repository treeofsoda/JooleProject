package com.Joole.demo.Controller;

import com.Joole.demo.Entity.Product;
import com.Joole.demo.Entity.User;
import com.Joole.demo.Service.ProductService;
import com.Joole.demo.Service.UserService;
import com.Joole.demo.Service.impl.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("User")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<?> Create(@RequestBody User user) {
        try {
            userService.Create(user);
        } catch (Exception e) {
            return new ResponseEntity<>("{\"error\":\"something wrong happens when creating new user!\"}",
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/findOne")
    public ResponseEntity<?> findByOneId(@RequestParam(name = "user_name") String user_name){
        User userToFind = userService.findByOneId(user_name);
        if (userToFind == null) {
            return new ResponseEntity<>("{\"error\":\"user not found!\"}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userToFind.toString() + "is found", HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> readAll(){
        List<User> userList;
        try {
            userList = userService.readAll();
        } catch (Exception e) {
            return new ResponseEntity<>("{\"error\":\"cannot read!\"}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userList.toString(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> Update(@RequestBody User user_name){
        try {
            userService.Create(user_name);
        } catch (Exception e) {
            return new ResponseEntity<>("{\"error\":\"something wrong happens when updating user!\"}",
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteOne")
    public ResponseEntity<?> Delete(@RequestParam("user_name") String user_name){
        User userToDelete = userService.findByOneId(user_name);
        if (userToDelete == null) {
            return new ResponseEntity<>("{\"error\":\"product not found!\"}", HttpStatus.BAD_REQUEST);
        }
        userService.delete(user_name);
        return new ResponseEntity<>(userToDelete.toString() + "is deleted", HttpStatus.OK);
    }

//    @GetMapping
//    public List<User> getAllUsers(){
//        return userService.getAllUsers();
//    }
//
//
//    @GetMapping(path = "{studentId}/courses")
//    public List<Project> getAllUserForProject(
//            @PathVariable("owner") String owner){//use String or User???
//        return UserService.getAllUserForProject(owner);
//    }
//
//    @PostMapping
//    public void addNewUser(@RequestBody @Valid User user){
//        studentService.addNewUser(user);
//    }

}
