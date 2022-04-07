package com.Joole.demo.Service.impl;


import com.Joole.demo.Entity.User;
import com.Joole.demo.Repository.UserRepository;
import com.Joole.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    public void createTwo() {
        User tempUser1 = new User(
                "MSJPURF",
                "user",
                "asdfqwe",
                LocalDateTime.now(),
                LocalDateTime.of(2000, 1, 1, 0, 0)
        );
        User tempUser2 = new User(
                "SudaTree123",
                "user",
                "123456",
                LocalDateTime.now(),
                LocalDateTime.of(2000, 2, 2, 0, 0)
        );
        userRepository.save(tempUser1);
        userRepository.save(tempUser2);
    }
}
