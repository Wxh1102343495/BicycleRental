package com.wxh.bicyclerental.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wxh.bicyclerental.entity.Coupon;
import com.wxh.bicyclerental.entity.Location;
import com.wxh.bicyclerental.service.ILocationService;
import com.wxh.bicyclerental.utils.Result;
import com.wxh.bicyclerental.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api
@RestController
@RequestMapping("/location")
@CrossOrigin
public class LocationController {

    @Autowired
    private ILocationService locationService;

    /**
     * 分页查询所有地址信息
     */
    @GetMapping("/queryLocation")
    @ApiOperation("分页查询所有地址信息")
    public Result queryLocation(@RequestParam int pageNo, @RequestParam int pageSize) {
        Map map = new HashMap<>();
        //使用PageHelper分页插件
        PageHelper.offsetPage(pageNo, pageSize);
        PageInfo<Location> locationList = PageInfo.of(locationService.select());
        map.put("total", locationList.getTotal());
        map.put("data", locationList.getList());
        return Result.ok().data(map);
    }

    /**
     * 查询所有地址信息
     */
    @GetMapping("/findAllLocation")
    @ApiOperation("查询所有地址信息")
    public Result findAllLocation() {
        return Result.ok().data(locationService.select());
    }

    /**
     * 新增地址信息
     */
    @PostMapping("/addLocation")
    @ApiOperation("新增地址信息")
    public Result addLocation(@RequestBody Location location) {
        // 设置默认状态为1
        location.setState(1);
        if(locationService.insert(location) > 0) {
            return Result.ok().data("添加成功");
        }else {
            return Result.error().data("添加失败");
        }
    }

    /**
     * 删除地址信息
     */
    @GetMapping("/removeLocation")
    @ApiOperation("删除地址信息")
    public Result removeLocation(@RequestParam Integer id) {
        if(null == id || "".equals(id)) {
            return Result.error().data("删除失败");
        }
        if (locationService.removeLocation(id) > 0) {
            return Result.ok().data("删除成功");
        } else {
            return Result.error().data("删除失败");
        }
    }

    /**
     * 修改地址信息
     */
    @PostMapping("/updateLocation")
    @ApiOperation("修改地址信息")
    public Result updateLocation(@RequestBody Location location) {
        if(StringUtils.isNull(location)) {
            return Result.error().data("修改失败");
        }
        if (locationService.update(location) > 0) {
            return Result.ok().data("修改成功");
        } else {
            return Result.error().data("修改失败");
        }
    }
}
