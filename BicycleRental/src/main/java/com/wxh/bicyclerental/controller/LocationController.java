package com.wxh.bicyclerental.controller;

import com.wxh.bicyclerental.entity.Location;
import com.wxh.bicyclerental.service.ILocationService;
import com.wxh.bicyclerental.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping("/location")
@CrossOrigin
public class LocationController {

    @Autowired
    private ILocationService locationService;

    /**
     * 查询所有地址信息
     */
    @GetMapping("/queryLocation")
    @ApiOperation("查询所有地址信息")
    public Result queryLocation() {
        List<Location> locationList = locationService.select();
        if (null == locationList || locationList.size() == 0) {
            return Result.error().data("查询失败");
        } else {
            return Result.ok().data(locationList);
        }
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
}
