package com.Joole.demo.Service;


import com.Joole.demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api.v1.users")
public class UserService {
    private static final List<User> USERS = Arrays.asList(
            new User(
                    "MSJPURF",
                    "user",
                    "asdfqwe",
                    LocalDateTime.now(),
                    LocalDateTime.of(2000, 1, 1, 0, 0)
            ),
            new User(
                    "SudaTree123",
                    "user",
                    "123456",
                    LocalDateTime.now(),
                    LocalDateTime.of(2000, 2, 2, 0, 0)
            )
            
    );
    
    @GetMapping(path = "{user_name}")
    public User getUser(@PathVariable("user_name") String user_name){
        return USERS.stream()
                .filter(user -> user_name.equals(user.getUser_name()))
                .findFirst()
                .orElseThrow(()->new IllegalStateException(
                        "User " + user_name + "do not exist"
                ));
    }
    
    
}
