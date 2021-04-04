package com.wxh.bicyclerental.service;

import com.wxh.bicyclerental.entity.UserCoupon;

import java.util.List;

public interface IUserCouponService {
    public List<UserCoupon> selectCouponByUserName(String username);
    public Integer selectByUidAndCid(UserCoupon userCoupon);
    public Integer selectByCouponId(Long couponId);
    public UserCoupon selectByUserId(Integer userId);
    public List<UserCoupon> selectAll(String username);
    public int insert(UserCoupon userCoupon);
    public int delete(Integer id);
    public int updateState(Integer id);
}
