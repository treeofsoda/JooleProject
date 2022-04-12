package com.Joole.demo.Service.impl;


import com.Joole.demo.Entity.User;
import com.Joole.demo.Repository.UserRepository;
import com.Joole.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User Create(User user) {
//        User tempUser1 = new User(
//                "MSJPURF",
//                "user",
//                "asdfqwe",
//                LocalDateTime.now(),
//                LocalDateTime.of(2000, 1, 1, 0, 0)
//        );
//        userRepository.save(tempUser1);
//        return tempUser1;
        if (userRepository.existsById(user.getUser_name())) {
            //need Exception
        }
        userRepository.save(user);
        return user;
    }
    @Override
    public User findByOneId(String userName) {
        return userRepository.findById(userName).orElse(null);
    }

    @Override
    public List<User> readAll(){
        List<User> list = userRepository.findAll();
        return list;
    }

    @Override
    @Transactional
    public User update(User user) {
        return userRepository.save(user);
    }


    @Override
    @Transactional
    public void delete(String userName) {
        userRepository.deleteById(userName);
    }

}
