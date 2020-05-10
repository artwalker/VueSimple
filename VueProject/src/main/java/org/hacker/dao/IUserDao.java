package org.hacker.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.hacker.domain.User;

import java.util.List;

/**
 * @author HackerStar
 * @create 2020-05-05 11:37
 */
public interface IUserDao {
    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where id = #{userId}")
    User findById(Integer id);

    @Update("update user set username=#{username}, password=#{password},age=#{age},sex=#{sex},email=#{email} where id=#{id}")
    void updateUser(User user);
}
