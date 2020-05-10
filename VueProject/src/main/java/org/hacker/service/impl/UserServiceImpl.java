package org.hacker.service.impl;

import org.hacker.dao.IUserDao;
import org.hacker.domain.User;
import org.hacker.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HackerStar
 * @create 2020-05-05 11:35
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(Integer userID) {
        return userDao.findById(userID);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
