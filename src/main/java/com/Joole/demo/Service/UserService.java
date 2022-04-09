package com.Joole.demo.Service;


import com.Joole.demo.Entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

    @Transactional
    List<User> Create();

    User findByUsername(String username);

    String readAll();

    User Update(User user);

    void Delete(String username);
}
