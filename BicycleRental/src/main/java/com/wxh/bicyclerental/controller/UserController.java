package com.wxh.bicyclerental.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    @PostMapping("/register")
    @ApiOperation("注册")
    public Result registerUser(@RequestBody User user) {
        System.out.println(user);
        if(StringUtils.isNull(userService.selectByUserName(user.getUsername()))) {
            //默认是用户注册
            user.setIdentity("user");
            userService.insert(user);
            return Result.ok().data("注册成功");
        }
        return Result.error().data("该用户已存在");
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
    @ApiOperation("获取用户信息")
    public Result getInfo(HttpServletRequest request) {
        // 获取jwt解析的信息（用户的id）
        Integer memberIdByJwtToken = Integer.parseInt(JwtUtils.getMemberIdByJwtToken(request));
        // 根据id，查询用户的信息，并将他放入data数据中
        User user = userService.selectOne(memberIdByJwtToken);
        Map map = new HashMap<>();
        ArrayList<String> rolesList = new ArrayList<String>();
        if (StringUtils.isNotNull(user)) {
            rolesList.add(user.getIdentity());
            map.put("roles", JSONArray.parseArray(JSONObject.toJSONString(rolesList)));
            map.put("password", user.getPassword());
            map.put("name", user.getUsername());
            map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            return Result.ok().data(map);
        }
        return Result.error();
    }

    /**
     * 授权为系统管理员或取消管理员权限
     */
    @PostMapping("/updateIdentity")
    @ApiOperation("授权或取消权限")
    public int updateIdentity(@RequestBody User params) {
        Integer id = params.getId();
        String identity = params.getIdentity();
        User user = new User();
        user.setId(id);
        user.setIdentity(identity);
        return userService.updateIdentity(user);
    }

    /**
     * 分页查询用户信息
     */
    @GetMapping("/pageQueryUser")
    @ApiOperation("分页查询用户信息")
    public Result pageQueryUser(@RequestParam int pageNo, @RequestParam int pageSize) {
        Map map = new HashMap<>();
        //使用PageHelper分页插件
        PageHelper.offsetPage(pageNo, pageSize);
        PageInfo<User> userList = PageInfo.of(userService.selectUserByPage());
        map.put("total",userList.getTotal() );
        map.put("data", userList.getList());
        return Result.ok().data(map);
    }
}
