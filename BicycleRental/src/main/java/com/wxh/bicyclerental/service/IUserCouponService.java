package com.wxh.bicyclerental.service;

import com.wxh.bicyclerental.entity.UserCoupon;

import java.util.List;

public interface IUserCouponService {
    public List<UserCoupon> selectCouponByUserName(String username);
    public Integer selectByUidAndCid(UserCoupon userCoupon);
    public int insert(UserCoupon userCoupon);
    public int delete(Integer id);
}
