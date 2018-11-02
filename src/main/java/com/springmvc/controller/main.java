package com.springmvc.controller;

import com.springmvc.pojo.Admin;
import com.springmvc.pojo.User;
import com.springmvc.service.AdminService;
import com.springmvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class main {

    @Resource
    AdminService adminService;

    @Resource
    UserService userService;

    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "hello world";
    }

    @RequestMapping(value = "/admin",method = RequestMethod.POST)
    @ResponseBody
    public int insertUser(Admin admin){
       return adminService.insertAdmin(admin);

    }
    @RequestMapping(value = "/admin/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Admin getUser(@PathVariable  Integer id){
        return adminService.getAdmin(id);
    }


    @RequestMapping(value = "/adduser",method = RequestMethod.GET)
    @ResponseBody
    public String addUser(User user){
        userService.insertUser(user);
        return "插入成功";
    }
    @RequestMapping(value = "/readuser",method = RequestMethod.GET)
    @ResponseBody
    public User readUser(int id){
        return userService.getUser(id);
    }
}
