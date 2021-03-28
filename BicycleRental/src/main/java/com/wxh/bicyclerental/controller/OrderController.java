package com.wxh.bicyclerental.controller;

import com.sun.org.apache.xpath.internal.operations.Or;
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

import java.util.List;

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

    /**
     * 查询正在进行订单
     */
    @GetMapping("/queryUserOrderIng")
    @ApiOperation("查询正在进行订单")
    public Result queryUserOrderIng(@RequestParam String username, @RequestParam Integer state) {
        //根据用户名查用户id
        User user = userService.selectByUserName(username);
        Integer uid = user.getId();
        Order order = new Order();
        order.setUserId(uid);
        order.setState(state);
        List<Order> orders = orderService.selectByUserAndState(order);
        if (orders.size()>0 && null != orders) {
            return Result.ok().data(orders);
        } else {
            return Result.error().data("查询失败");
        }
    }

    /**
     * 删除订单
     */
    @PostMapping("/removeOrder")
    @ApiOperation("删除订单")
    public Result removeOrder(@RequestBody Order order) {
        if (orderService.delete(order.getOrderId())>0) {
            return Result.ok().data("成功");
        } else {
            return Result.error().data("失败");
        }
    }
}
