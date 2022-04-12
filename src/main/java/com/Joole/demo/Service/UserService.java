package com.Joole.demo.Service;

import com.Joole.demo.Entity.Project;
import com.Joole.demo.Entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {


    @Transactional
    User Create(User user);

    User findByOneId(String userName);

    List<User> readAll();

    @Transactional
    User update(User user);

    @Transactional
    void delete(String userName);
}
