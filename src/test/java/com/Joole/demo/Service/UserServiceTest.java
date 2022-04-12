package com.Joole.demo.Service;

import com.Joole.demo.Entity.User;
import com.Joole.demo.Repository.UserRepository;
import com.Joole.demo.Service.impl.UserServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserServiceImp userServiceImp;

    @Autowired
    private UserRepository userRepository;
    @Test
    public void Create() {
        User user = new User("ForService",
                "owner",
                "123456",
                LocalDateTime.now(),
                LocalDateTime.of(2000, 1, 1, 0, 0)
                );
        userServiceImp.Create(user);
        Assertions.assertEquals(user.getUser_name(),
                userRepository.findById("ForService").get().getUser_name());
    }
}
