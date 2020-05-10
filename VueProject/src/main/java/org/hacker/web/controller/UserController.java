package org.hacker.web.controller;

import org.hacker.domain.User;
import org.hacker.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author HackerStar
 * @create 2020-05-05 11:28
 */
@Controller
@RequestMapping("/user")
@ResponseBody
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/findAll")
    public List<User> findAll() {
        System.out.println("findAll");
        return userService.findAll();
    }

    @RequestMapping("/findById")
    public User findById(Integer id) {
        return userService.findById(id);
    }

    @RequestMapping("/updateUser")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }
}
