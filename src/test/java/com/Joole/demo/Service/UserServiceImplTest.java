package com.Joole.demo.Service;

import com.Joole.demo.Entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    public void saveUser() {
        User user = new User();
        user.setUsername("qsl333i");
        user.setPassword("12345678");
        userService.saveUser(user);
        System.out.println(user);
        Assert.assertEquals("qsli",user.getUsername());

    }

    @Test
    public void findByUsername() {
    }

    @Test
    public void create() {
    }
}