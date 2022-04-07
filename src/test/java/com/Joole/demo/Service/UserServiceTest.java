package com.Joole.demo.Service;

import com.Joole.demo.Repository.UserRepository;
import com.Joole.demo.Service.impl.UserServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.Joole.demo.Service.UserService;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserServiceImp userServiceImp;

    @Test
    public void createTwoTest() {
        userServiceImp.createTwo();
    }

}