package com.wxh.bicyclerental.controller;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.wxh.bicyclerental.entity.Bicycle;
import com.wxh.bicyclerental.entity.Order;
import com.wxh.bicyclerental.entity.User;
import com.wxh.bicyclerental.service.IOrderService;
import com.wxh.bicyclerental.service.IUserService;
import com.wxh.bicyclerental.utils.CodeUtil;
import com.wxh.bicyclerental.utils.Result;
import com.wxh.bicyclerental.utils.TimeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    /**
     * 还车操作订单完成
     */
    @PostMapping("/finishOrder")
    @ApiOperation("还车操作订单完成")
    public Result finishOrder(@RequestBody Order order) {
        //对日期进行操作
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取当前系统时间
        Date thisDate = new Date();
        String thisTime = df.format(thisDate);
        //获取开始时间
        String startTime = df.format(order.getStartTime());
        //调用工具类判断租赁时间
        float hours = (float) TimeUtils.differHours(startTime, thisTime);
        //设置调用所需实体
        Order rquestOrder = new Order();
        rquestOrder.setOrderId(order.getOrderId());
        rquestOrder.setEndTime(thisDate);
        rquestOrder.setEvaluation(order.getEvaluation());
        //先将数据插入表中设置订单状态为未支付
        rquestOrder.setState(2);
        //判断租赁方式获取租赁价格
        if("时租".equals(order.getRentMode())) {
            //获取租赁价格
            Float hourRent = order.getBicycle().getHourRent();
            //计算总租金
            float rant = hours * hourRent;
            rquestOrder.setRent(rant);
            int response = orderService.updateOrderEnd(rquestOrder);
            if(response>0) {
                return Result.ok().data("成功");
            }
        }
        if("日租".equals(order.getRentMode())) {
            //获取租赁价格
            Float hourRent = order.getBicycle().getHourRent();
            Float dayRent = order.getBicycle().getDayRent();
            int h = (int) hours;
            //租赁时长不足一天，则按一天计算
            if(h < 24) {
                rquestOrder.setRent(dayRent);
            }else {
                //判断能否整除24小时，不能则将多余部分按小时计费
                if(h % 24 != 0 ){
                    int i = h % 24;
                    float rant1 = i * hourRent;
                    float rant2 = ((h - i) / 24) * dayRent;
                    rquestOrder.setRent(rant1+rant2);
                }else {
                    float rant = (h / 24) * dayRent;
                    rquestOrder.setRent(rant);
                }
            }
            int response = orderService.updateOrderEnd(rquestOrder);
            if(response>0) {
                return Result.ok().data("成功");
            }
        }
        if("月租".equals(order.getRentMode())) {
            Float dayRent = order.getBicycle().getDayRent();
            Float monthRent = order.getBicycle().getMonthRent();
            int h = (int) hours;
            //租赁时长不足30天，则按一月计算
            if(h < (30*24)) {
                rquestOrder.setRent(monthRent);
            }else {
                if(h % 720 != 0) {
                    int i = h % 720;
                    int days = (int)Math.ceil(i / 24);
                    float rant1 = days * dayRent;
                    float rant2 = ((h - i) / 720) * monthRent;
                    rquestOrder.setRent(rant1+rant2);
                }else {
                    float rant = (h / 720) * monthRent;
                    rquestOrder.setRent(rant);
                }
            }
            int response = orderService.updateOrderEnd(rquestOrder);
            if(response>0) {
                return Result.ok().data("成功");
            }
        }
        return Result.error().data("失败");
    }
}
