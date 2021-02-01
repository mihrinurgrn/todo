package com.mng.todo.service;

import com.mng.todo.model.User;

public interface UserService {
    User save(User user);

    User getUser(String username);

    User getUserById(Integer userId);

    void deleteUser(Integer userId);
}
