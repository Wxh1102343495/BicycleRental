package com.wxh.bicyclerental.controller;

import com.wxh.bicyclerental.entity.Bicycle;
import com.wxh.bicyclerental.service.IBicycleService;
import com.wxh.bicyclerental.utils.Result;
import com.wxh.bicyclerental.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("/bicycle")
@CrossOrigin
public class BicycleController {
    @Autowired
    private IBicycleService bicycleService;

    /**
     * 新车录入
     */
    @PostMapping("/addBicycle")
    @ApiOperation("新车录入")
    public Result addBicycle(@RequestBody Bicycle bicycle) {
        return null;
    }
}
