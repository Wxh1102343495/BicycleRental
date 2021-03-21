package com.wxh.bicyclerental.controller;

import com.wxh.bicyclerental.entity.Coupon;
import com.wxh.bicyclerental.service.ICouponService;
import com.wxh.bicyclerental.utils.CodeUtil;
import com.wxh.bicyclerental.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("/coupon")
@CrossOrigin
public class CouponController {

    @Autowired
    private ICouponService couponService;

    /**
     * 发布新优惠券
     */
    @PostMapping("/addCoupon")
    @ApiOperation("发布新优惠券")
    public Result addCoupon(@RequestBody Coupon coupon) {
        //设置状态为1
        coupon.setState(1);
        //生成7位id
        Integer id = CodeUtil.UCode();
        coupon.setCouponId(id);
        if(couponService.insert(coupon) > 0) {
            return Result.ok().data("添加成功");
        }else {
            return Result.error().data("添加失败");

        }
    }
}
