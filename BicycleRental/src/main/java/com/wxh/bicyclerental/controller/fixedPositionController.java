package com.wxh.bicyclerental.controller;

import com.wxh.bicyclerental.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * 模拟定位
 */
@Api
@RestController
@RequestMapping("/fixed")
@CrossOrigin
public class fixedPositionController {
    /**
     * 自行车定位
     */
    @GetMapping("/findFixed")
    @ApiOperation("自行车定位")
    public Result findFixed() {
        //1:表示未超出运营区，0:表示超出运营区
        //模拟设置未超出运营区
        Integer fixedNum = 1;
        return Result.ok().data(fixedNum);
    }
}
