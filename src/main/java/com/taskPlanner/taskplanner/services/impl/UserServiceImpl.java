package com.taskPlanner.taskplanner.services.impl;

import com.taskPlanner.taskplanner.model.User;
import com.taskPlanner.taskplanner.services.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CARLOS
 */
@Service
public class UserServiceImpl implements UserService {
    List<User> users = new ArrayList<>();
    public UserServiceImpl() {
        this.users = new ArrayList<>();
        this.users.add(new User("1","carlos","carlos@mail","123"));
    }
    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User getById(String userId) {
        User user = null;
        for (User u : users){
            if(u.getUserId().equals(userId)) user = u;
        }
        return user;
    }

    @Override
    public User create(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User update(User user) {
        User newUser = getById(user.getUserId()) ;
        if (!(user.getFullName() == null)){
            newUser.setFullName(user.getFullName());
        }
        if (!(user.getEmail() == null)){
            newUser.setEmail(user.getEmail());
        }
        if (!(user.getPassword() == null)){
            newUser.setPassword(user.getPassword());
        }
        return newUser;
    }

    @Override
    public void remove(String userId) {
        User user = getById(userId);
        users.remove(user);
    }
}
