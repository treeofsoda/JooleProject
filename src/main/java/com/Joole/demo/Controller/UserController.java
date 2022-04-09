package com.Joole.demo.Controller;

import com.Joole.demo.Entity.Project;
import com.Joole.demo.Entity.User;
import com.Joole.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/User")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/Create")
    public List<User> Create() {
        return userService.Create();
    }

    @GetMapping("/findOne")
    public User findByUsername(String username){
        return userService.findByUsername(username);
    }

    @GetMapping("/ReadAll")
    public String readAll(){
        return userService.readAll();
    }

    @PostMapping("/Update")
    public User Update(@RequestParam User user){
        return userService.Update(user);
    }

    @DeleteMapping("/Delete")
    public void Delete(@RequestParam("user_name") String username){
        userService.Delete(username);
    }

//    public UserController(UserService userService){
//        this.userService = userService;
//    }

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
