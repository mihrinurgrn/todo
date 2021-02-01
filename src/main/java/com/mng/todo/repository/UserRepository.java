package com.mng.todo.repository;


import com.mng.todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findAll();

    User getUserByUserName(String username);
    User findUserByUserId(Integer userId);

   @Override
    void delete(User user);
}
