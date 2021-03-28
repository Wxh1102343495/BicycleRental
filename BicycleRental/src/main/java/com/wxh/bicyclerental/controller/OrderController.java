package com.wxh.bicyclerental.controller;

import com.wxh.bicyclerental.entity.Order;
import com.wxh.bicyclerental.entity.User;
import com.wxh.bicyclerental.service.IOrderService;
import com.wxh.bicyclerental.service.IUserService;
import com.wxh.bicyclerental.utils.CodeUtil;
import com.wxh.bicyclerental.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IUserService userService;

    /**
     * 订单生成
     */
    @PostMapping("/creatOrder")
    @ApiOperation("订单生成")
    public Result creatOrder(@RequestParam(value = "username") String username, @RequestBody Order order) {
        //根据用户名查用户id
        User user = userService.selectByUserName(username);
        Integer uid = user.getId();
        order.setUserId(uid);
        //设置状态为1
        order.setState(1);
        //生成7位id
        Integer id = CodeUtil.UCode();
        order.setOrderId(id);
        if (orderService.insert(order) > 0) {
            return Result.ok().data("添加成功");
        } else {
            return Result.error().data("添加失败");
        }
    }
}
