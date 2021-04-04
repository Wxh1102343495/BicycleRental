package com.wxh.bicyclerental.service;

import com.wxh.bicyclerental.entity.Coupon;

import java.util.List;

public interface ICouponService {
    public Coupon selectOne(Long couponId);
    public List<Coupon> select();
    public int insert(Coupon coupon);
    public int delete(Long id);
    public int update(Coupon coupon);
    public List<Coupon> selectByState(Integer state);
}
