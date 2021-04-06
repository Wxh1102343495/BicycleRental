package com.wxh.bicyclerental.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wxh.bicyclerental.entity.Advise;
import com.wxh.bicyclerental.entity.User;
import com.wxh.bicyclerental.service.IAdviseService;
import com.wxh.bicyclerental.service.IUserService;
import com.wxh.bicyclerental.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 投诉意见管理
 */
@Api
@RestController
@RequestMapping("/advise")
@CrossOrigin
public class AdviseController {

    @Autowired
    private IAdviseService adviseService;

    @Autowired
    private IUserService userService;

    /**
     * 添加新投诉
     */
    @PostMapping("/addAdvise")
    @ApiOperation("添加新投诉")
    public Result addAdvise(@RequestBody Advise advise,@RequestParam String username) {
        //根据用户名查询用户id
        User user = userService.selectByUserName(username);
        Integer id = user.getId();
        advise.setUserId(id);
        //设置状态为0
        advise.setState(0);
        if(adviseService.insert(advise) > 0) {
            return Result.ok().data("添加成功");
        }else {
            return Result.error().data("添加失败");
        }
    }

    /**
     * 根据状态分页查询投诉建议
     */
    @GetMapping("/findByState")
    @ApiOperation("根据状态分页查询投诉建议")
    public Result findByState(@RequestParam Integer state, @RequestParam int pageNo, @RequestParam int pageSize) {
        Map map = new HashMap<>();
        //使用PageHelper分页插件
        PageHelper.offsetPage(pageNo, pageSize);
        PageInfo<Advise> adviseList = PageInfo.of(adviseService.select(state));
        map.put("total", adviseList.getTotal());
        map.put("data", adviseList.getList());
        return Result.ok().data(map);
    }

    /**
     * 修改投诉状态
     */
    @PostMapping("/updateState")
    @ApiOperation("修改投诉状态")
    public Result updateState(@RequestBody Advise advise) {
        Integer id = advise.getId();
        if(adviseService.delete(id) > 0) {
            return Result.ok().data("修改成功");
        }else {
            return Result.error().data("修改失败");
        }
    }
}
