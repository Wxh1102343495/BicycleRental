package com.wxh.bicyclerental.controller;

import com.alibaba.fastjson.JSON;
import com.wxh.bicyclerental.entity.User;
import com.wxh.bicyclerental.service.IUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * 新用户注册
     */
    @PostMapping("/regist")
    @ApiOperation("注册")
    public int registerUser(@RequestBody User user) {
        //默认是用户注册
        user.setIdentity("user");
        return userService.insert(user);
    }

    /**
     * 用户登录
     */
    @PostMapping("/login")
    @ApiOperation("登录")
    public int login(@RequestBody User user) {

        return userService.insert(user);
    }

    /**
     * 授权为系统管理员或取消管理员权限
     */
    @PostMapping("/updateIdentity")
    @ApiOperation("授权或取消权限")
    public int updateIdentity(@RequestBody String str) {
        //获取请求中的id
        Integer userId = Integer.parseInt(JSON.parseObject(str).get("id").toString());
        //获取请求中的identity
        String identity = JSON.parseObject(str).get("identity").toString();
        //List<User> userId = JSON.parseArray(JSON.parseObject(str).getString("userApplyDetailInfos"), User.class);
        User user = new User();
        user.setId(userId);
        user.setIdentity(identity);
        return userService.updateIdentity(user);
    }
}
