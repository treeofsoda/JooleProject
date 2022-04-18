package com.Joole.demo.Service;

import java.util.List;
import com.Joole.demo.Entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User saveUser(User user);

    User findByUsername(String username);

    List<User> findAllUsers();

    public boolean create(User user);
    public boolean delete(User user);
    public User get(String userName);
    public boolean update(String userName, User user);
    public void clear();
}
