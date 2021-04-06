package com.wxh.bicyclerental.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wxh.bicyclerental.entity.Bicycle;
import com.wxh.bicyclerental.service.IBicycleService;
import com.wxh.bicyclerental.utils.CodeUtil;
import com.wxh.bicyclerental.utils.Result;
import com.wxh.bicyclerental.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 自行车管理
 */
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

    /**
     * 查询所有自行车信息
     */
    @GetMapping("/findAll")
    @ApiOperation("查询所有自行车信息")
    public Result findAll() {
        return Result.ok().data(bicycleService.select());
    }

    /**
     * 分页查询自行车信息
     */
    @GetMapping("/pageQueryBicycle")
    @ApiOperation("分页查询自行车信息")
    public Result pageQueryBicycle(@RequestParam int pageNo, @RequestParam int pageSize) {
        Map map = new HashMap<>();
        //使用PageHelper分页插件
        PageHelper.offsetPage(pageNo, pageSize);
        PageInfo<Bicycle> bicycleList = PageInfo.of(bicycleService.select());
        map.put("total", bicycleList.getTotal());
        map.put("data", bicycleList.getList());
        return Result.ok().data(map);
    }

    /**
     * 根据自行车编码查询自行车信息
     */
    @PostMapping("/findByCode")
    @ApiOperation("根据自行车编码查询自行车信息")
    public Result findByCode(@RequestBody Bicycle bicycle) {
        if(StringUtils.isNull(bicycle)) {
            return Result.error().data("失败");
        }else {
            Long bicycleCode = bicycle.getBicycleCode();
            return Result.ok().data(bicycleService.selectOne(bicycleCode));
        }
    }

    /**
     * 将自行车状态设为2（报废）删除操作
     */
    @GetMapping("/removeBicycle")
    @ApiOperation("删除自行车")
    public Result removeBicycle(@RequestParam Long bicycleCode) {
        if(bicycleService.removeBicycle(bicycleCode) > 0) {
            return Result.ok().data("删除成功");
        }else {
            return Result.error().data("删除失败");
        }
    }
}
