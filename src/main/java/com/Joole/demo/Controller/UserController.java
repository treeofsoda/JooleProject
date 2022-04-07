package com.Joole.demo.Controller;

import com.Joole.demo.Entity.Project;
import com.Joole.demo.Entity.User;
import com.Joole.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("User")
public class UserController {
    private final UserService userService;
    
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
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
