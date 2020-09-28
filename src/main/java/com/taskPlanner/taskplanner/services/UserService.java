package com.taskPlanner.taskplanner.services;

import com.taskPlanner.taskplanner.model.User;
import java.util.List;

/**
 * @author CARLOS
 */
public interface UserService {
    List<User> getAll();

    User getById(String userId);

    User create(User user);

    User update(User user);

    void remove(String userId);
}
