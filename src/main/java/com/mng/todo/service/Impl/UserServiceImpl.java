package com.mng.todo.service.Impl;

import com.mng.todo.model.User;
import com.mng.todo.repository.UserRepository;
import com.mng.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        try
        {
            if(user!=null)
            {
                return userRepository.save(user);
            }
        }
        catch(NullPointerException n)
        {
            n.printStackTrace();
        }
        return userRepository.save(user);
    }

    @Override
    public User getUser(String username) {
        return userRepository.getUserByUserName(username);
    }

    @Override
    public User getUserById(Integer userId) {
        User user=userRepository.findUserByUserId(userId);
        try
        {
            if(user!=null)
            {
                return user;
            }
        }
        catch(NullPointerException n)
        {
            n.printStackTrace();
        }
        return user;
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.delete(userRepository.findUserByUserId(userId));
    }


}
