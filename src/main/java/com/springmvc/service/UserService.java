package com.springmvc.service;

import com.springmvc.dao.UserMapper;
import com.springmvc.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("UserService")

public class UserService {
    @Resource
    private UserMapper userMapper;


    public User getUser(int id){
        User a=this.userMapper.selectByPrimaryKey(id);
        if(a!=null){
            return a;
        }
        return null;
    }

    public int insertUser(User user){
        return this.userMapper.insert(user);
    }
}
