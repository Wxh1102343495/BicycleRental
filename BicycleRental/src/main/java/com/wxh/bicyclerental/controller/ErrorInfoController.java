package com.wxh.bicyclerental.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wxh.bicyclerental.entity.ErrorInfo;
import com.wxh.bicyclerental.entity.User;
import com.wxh.bicyclerental.service.IErrorInfoService;
import com.wxh.bicyclerental.service.IUserService;
import com.wxh.bicyclerental.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 自行车故障管理
 */
@Api
@RestController
@RequestMapping("/errorInfo")
@CrossOrigin
public class ErrorInfoController {
    @Autowired
    private IErrorInfoService errorInfoService;

    @Autowired
    private IUserService userService;

    /**
     * 分页查询故障信息
     */
    @GetMapping("/queryErrorInfo")
    @ApiOperation("分页查询故障信息")
    public Result queryErrorInfo(@RequestParam int pageNo, @RequestParam int pageSize) {
        Map map = new HashMap<>();
        //使用PageHelper分页插件
        PageHelper.offsetPage(pageNo, pageSize);
        PageInfo<ErrorInfo> errorInfoList = PageInfo.of(errorInfoService.select());
        map.put("total", errorInfoList.getTotal());
        map.put("data", errorInfoList.getList());
        return Result.ok().data(map);
    }

    /**
     * 修改维修状态
     */
    @GetMapping("/editErrorInfo")
    @ApiOperation("修改维修状态")
    public Result editErrorInfo(@RequestParam Integer id) {
        if (null == id || "".equals(id)) {
            return Result.error().data("修改失败");
        }
        if (errorInfoService.editErrorInfoState(id) > 0) {
            return Result.ok().data("修改成功");
        } else {
            return Result.error().data("修改失败");
        }
    }

    /**
     * 添加故障信息
     */
    @PostMapping("/addErrorInfo")
    @ApiOperation("添加故障信息")
    public Result addErrorInfo(@RequestBody ErrorInfo errorInfo, @RequestParam String username) {
        //根据用户名查询用户id
        User user = userService.selectByUserName(username);
        Integer id = user.getId();
        errorInfo.setUserId(id);
        errorInfo.setState(1);
        int resp = errorInfoService.insert(errorInfo);
        if (resp > 0) {
            return Result.ok().data("添加成功");
        } else {
            return Result.error().data("添加失败");
        }
    }
}
