package com.wxh.bicyclerental.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wxh.bicyclerental.entity.Coupon;
import com.wxh.bicyclerental.entity.User;
import com.wxh.bicyclerental.entity.UserCoupon;
import com.wxh.bicyclerental.service.IUserCouponService;
import com.wxh.bicyclerental.service.IUserService;
import com.wxh.bicyclerental.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户和优惠券中间表
 */
@Api
@RestController
@RequestMapping("/userCoupon")
@CrossOrigin
public class UserCouponController {

    @Autowired
    private IUserCouponService userCouponService;

    @Autowired
    private IUserService userService;

    /**
     * 根据用户名查询优惠券
     */
    @GetMapping("/findCouponByUsername")
    @ApiOperation("根据用户名查询优惠券")
    public Result findCouponByUsername(@RequestParam String username) {
        List<UserCoupon> userCouponList = userCouponService.selectCouponByUserName(username);
        return Result.ok().data(userCouponList);
    }

    /**
     * 根据优惠券id查询未支付的优惠券信息。
     *
     */
    @GetMapping("/findByCouponId")
    @ApiOperation("根据优惠券id查询未支付的优惠券信息")
    public Result findByCouponId(@RequestParam Long couponId) {
        return Result.ok().data(userCouponService.selectByCouponId(couponId));
    }

    /**
     * 根据用户名查询是否有需要支付的订单
     *
     */
    @GetMapping("/findByUsername")
    @ApiOperation("根据用户名查询是否有需要支付的订单")
    public Result findByUsername(@RequestParam String username) {
        //根据用户名查询用户id
        User user = userService.selectByUserName(username);
        Integer id = user.getId();
        return Result.ok().data(userCouponService.selectByUserId(id));
    }

    /**
     * 根据用户名和优惠券id查询该用户是否有这个优惠券，若有则不能重复购买
     *
     */
    @GetMapping("/findByUsernameAndCouponId")
    @ApiOperation("根据用户名和优惠券id查询该用户是否有这个优惠券")
    public Result findByUsernameAndCouponId(@RequestParam String username,@RequestParam Long couponId) {
        //根据用户名查询用户id
        User user = userService.selectByUserName(username);
        Integer id = user.getId();
        UserCoupon userCoupon = new UserCoupon();
        userCoupon.setUserId(id);
        userCoupon.setCouponId(couponId);
        return Result.ok().data(userCouponService.selectByUidAndCid(userCoupon));
    }

    /**
     * 分页查询用户所有的优惠券
     */
    @GetMapping("/findAll")
    @ApiOperation("分页查询用户所有优惠券")
    public Result findAll(@RequestParam int pageNo, @RequestParam int pageSize,@RequestParam String username) {
        Map map = new HashMap<>();
        //使用PageHelper分页插件
        PageHelper.offsetPage(pageNo, pageSize);
        PageInfo<UserCoupon> userCouponList = PageInfo.of(userCouponService.selectAll(username));
        map.put("total", userCouponList.getTotal());
        map.put("data", userCouponList.getList());
        return Result.ok().data(map);
    }
}
