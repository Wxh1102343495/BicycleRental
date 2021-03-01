package com.wxh.bicyclerental.controller;

import com.wxh.bicyclerental.entity.Location;
import com.wxh.bicyclerental.service.ILocationService;
import com.wxh.bicyclerental.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
