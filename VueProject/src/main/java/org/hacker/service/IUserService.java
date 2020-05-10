package org.hacker.service;

import org.hacker.domain.User;

import java.util.List;

/**
 * @author HackerStar
 * @create 2020-05-05 11:06
 */
public interface IUserService {
    List<User> findAll();

    User findById(Integer userID);

    void updateUser(User user);
}
