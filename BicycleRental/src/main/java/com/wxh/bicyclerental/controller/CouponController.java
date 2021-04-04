package com.wxh.bicyclerental.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wxh.bicyclerental.entity.Coupon;
import com.wxh.bicyclerental.entity.Order;
import com.wxh.bicyclerental.entity.User;
import com.wxh.bicyclerental.entity.UserCoupon;
import com.wxh.bicyclerental.service.ICouponService;
import com.wxh.bicyclerental.service.IUserCouponService;
import com.wxh.bicyclerental.service.IUserService;
import com.wxh.bicyclerental.utils.CodeUtil;
import com.wxh.bicyclerental.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 优惠券管理
 */
@Api
@RestController
@RequestMapping("/coupon")
@CrossOrigin
public class CouponController {

    @Autowired
    private ICouponService couponService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserCouponService userCouponService;

    /**
     * 发布新优惠券
     */
    @PostMapping("/addCoupon")
    @ApiOperation("发布新优惠券")
    public Result addCoupon(@RequestBody Coupon coupon) {
        //设置状态为1
        coupon.setState(1);
        //生成16位id
        Long id = CodeUtil.RundCode();
        coupon.setCouponId(id);
        if (couponService.insert(coupon) > 0) {
            return Result.ok().data("添加成功");
        } else {
            return Result.error().data("添加失败");
        }
    }

    /**
     * 分页查询所有优惠券
     */
    @GetMapping("/findAllCoupon")
    @ApiOperation("分页查询所有优惠券")
    public Result findAllCoupon(@RequestParam Integer state, @RequestParam int pageNo, @RequestParam int pageSize) {
        Map map = new HashMap<>();
        //使用PageHelper分页插件
        PageHelper.offsetPage(pageNo, pageSize);
        PageInfo<Coupon> couponList = PageInfo.of(couponService.selectByState(state));
        map.put("total", couponList.getTotal());
        map.put("data", couponList.getList());
        return Result.ok().data(map);
    }

    /**
     * 查询所有优惠券
     */
    @GetMapping("/findAll")
    @ApiOperation("查询所有优惠券")
    public Result findAll() {
        return Result.ok().data(couponService.select());
    }

    /**
     * 根据id查询优惠券
     */
    @PostMapping("/findByCouponId")
    @ApiOperation("根据id查询优惠券")
    public Result findByCouponId(@RequestBody Coupon coupon) {
        Long couponId = coupon.getCouponId();
        return Result.ok().data(couponService.selectOne(couponId));
    }

    /**
     * 更改优惠券状态
     */
    @PostMapping("/updateCouponState")
    @ApiOperation("更改优惠券状态")
    public Result updateCouponState(@RequestBody Coupon coupon) {
        if (couponService.update(coupon) > 0) {
            return Result.ok().data("修改成功");
        } else {
            return Result.error().data("修改失败");
        }
    }

    /**
     * 购买优惠券
     */
    @PostMapping("/buyCoupon")
    @ApiOperation("购买优惠券")
    public Result buyCoupon(@RequestBody Coupon coupon,@RequestParam String username) {
        //向中间表中插入数据
        UserCoupon userCoupon = new UserCoupon();
        //根据用户名查询用户id
        User user = userService.selectByUserName(username);
        Integer userId = user.getId();
        Long couponId = coupon.getCouponId();
        userCoupon.setCouponId(couponId);
        userCoupon.setUserId(userId);
        //将状态设置成未支付
        userCoupon.setState(2);
        int result = userCouponService.insert(userCoupon);
        if(result>0){
            return Result.ok().data("成功");
        }else {
            return Result.error().data("失败");
        }
    }
}
