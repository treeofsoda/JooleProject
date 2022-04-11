package com.Joole.demo.Service.impl;


import com.Joole.demo.Entity.User;
import com.Joole.demo.Repository.UserRepository;
import com.Joole.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User Create() {
        User tempUser1 = new User(
                "MSJPURF",
                "user",
                "asdfqwe",
                LocalDateTime.now(),
                LocalDateTime.of(2000, 1, 1, 0, 0)
        );
        userRepository.save(tempUser1);
        return tempUser1;
    }
}
