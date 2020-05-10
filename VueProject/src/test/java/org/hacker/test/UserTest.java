package org.hacker.test;

import org.hacker.domain.User;
import org.hacker.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author HackerStar
 * @create 2020-05-05 11:43
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserTest {
    @Autowired
    private IUserService userService;

    @Test
    public void testFindAll(){
        List<User> users = userService.findAll();
        System.out.println(users);
    }

    @Test
    public void testFindById(){
        User user = userService.findById(1);
        System.out.println(user);
    }

    @Test
    public void testUpdateUser(){
        User user = userService.findById(1);
        user.setUsername("张老师");
        userService.updateUser(user);
    }
}
