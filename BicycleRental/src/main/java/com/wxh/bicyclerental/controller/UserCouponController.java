package com.wxh.bicyclerental.controller;

import com.wxh.bicyclerental.entity.UserCoupon;
import com.wxh.bicyclerental.service.IUserCouponService;
import com.wxh.bicyclerental.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * 根据用户名查询优惠券
     */
    @GetMapping("/findCouponByUsername")
    @ApiOperation("根据用户名查询优惠券")
    public Result findCouponByUsername(@RequestParam String username) {
        List<UserCoupon> userCouponList = userCouponService.selectCouponByUserName(username);
        return Result.ok().data(userCouponList);
    }
}
