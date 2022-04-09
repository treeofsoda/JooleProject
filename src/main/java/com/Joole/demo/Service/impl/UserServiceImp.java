package com.Joole.demo.Service.impl;


import com.Joole.demo.Entity.User;
import com.Joole.demo.Repository.UserRepository;
import com.Joole.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
//    public User Create(){
//                User tempUser1 = new User(
//                "MSJPURF",
//                "user",
//                "asdfqwe",
//                LocalDateTime.now(),
//                LocalDateTime.of(2000, 1, 1, 0, 0)
//        );
////        User user = new User();
////        userRepository.save(user);
////        return user;
//        userRepository.save(tempUser1);
//        return tempUser1;
//    }
    public List<User> Create(){
        return List.of(
                new User(
                        "MSJPURF",
                        "user",
                        "asdfqwe",
                        LocalDateTime.now(),
                        LocalDateTime.of(2000, 1, 1, 0, 0)
                )
        );
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findById(username).orElse(null);
    }

    @Override
    public String readAll(){
        StringBuilder sb = new StringBuilder();
        List<User> list = (List<User>) userRepository.findAll();
        for(User u : list){
            sb.append(u.toString());
        }
        return sb.toString();
    }


    @Override
    public User Update(User user) {
        return userRepository.save(user);
    }


    @Override
    public void Delete(String username) {
        userRepository.deleteById(username);
    }
//    public void createTwo() {
//        User tempUser1 = new User(
//                "MSJPURF",
//                "user",
//                "asdfqwe",
//                LocalDateTime.now(),
//                LocalDateTime.of(2000, 1, 1, 0, 0)
//        );
//        User tempUser2 = new User(
//                "SudaTree123",
//                "user",
//                "123456",
//                LocalDateTime.now(),
//                LocalDateTime.of(2000, 2, 2, 0, 0)
//        );
//        userRepository.save(tempUser1);
//        userRepository.save(tempUser2);
//    }

//    public void Delete(String username){
//        return userRepository.deleteById(username);
//    }
}
