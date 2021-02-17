package com.wxh.bicyclerental.controller;

import com.alibaba.fastjson.JSON;
import com.wxh.bicyclerental.entity.User;
import com.wxh.bicyclerental.service.IUserService;
import com.wxh.bicyclerental.utils.JwtUtils;
import com.wxh.bicyclerental.utils.Result;
import com.wxh.bicyclerental.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Api
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
    public Result login(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        String password = requestUser.getPassword();
        User user = userService.selectByUserName(username);
        if (StringUtils.isNotNull(user)) {
            String id = user.getId().toString();
            String psw = user.getPassword();
            if (password.equals(psw)) {
                String token = JwtUtils.getJwtToken(id, username);
                Map map = new HashMap(16);
                map.put("token", token);
                return Result.ok().data(map);
            } else {
                return Result.error().data("密码错误");
            }
        }
        return Result.error().data("用户名输入错误");
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    @GetMapping("info")
    public Result getInfo(HttpServletRequest request) {
        // 获取jwt解析的信息（用户的id）
        Integer memberIdByJwtToken = Integer.parseInt(JwtUtils.getMemberIdByJwtToken(request));
        // 根据id，查询用户的信息，并将他放入data数据中
        User user = userService.selectOne(memberIdByJwtToken);
        Map map = new HashMap<>();
        if (StringUtils.isNotNull(user)) {
            map.put("userName", user.getUsername());
            map.put("id", user.getId());
            map.put("password", user.getPassword());
            map.put("name", user.getName());
            map.put("avatar", user.getName());
            return Result.ok().data(map);
        }
        return Result.error();
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
