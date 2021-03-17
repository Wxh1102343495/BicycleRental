package com.wxh.bicyclerental.controller;

import com.wxh.bicyclerental.entity.Bicycle;
import com.wxh.bicyclerental.service.IBicycleService;
import com.wxh.bicyclerental.utils.CodeUtil;
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
        //设置状态为1
        bicycle.setState(1);
        //生成16位id
        Long id = CodeUtil.RundCode();
        bicycle.setBicycleCode(id);
        if(bicycleService.insert(bicycle) > 0) {
            return Result.ok().data("添加成功");
        }else {
            return Result.error().data("添加失败");

        }
    }
}
