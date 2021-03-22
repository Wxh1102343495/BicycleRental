package com.wxh.bicyclerental.service.impl;

import com.wxh.bicyclerental.entity.Coupon;
import com.wxh.bicyclerental.mapper.CouponMapper;
import com.wxh.bicyclerental.service.ICouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponServiceImpl implements ICouponService {

    @Autowired
    private CouponMapper couponMapper;

    @Override
    public Coupon selectOne() {
        return couponMapper.selectOne();
    }

    @Override
    public List<Coupon> select() {
        return couponMapper.select();
    }

    @Override
    public int insert(Coupon coupon) {
        return couponMapper.insert(coupon);
    }

    @Override
    public int delete(Integer id) {
        return couponMapper.delete(id);
    }

    @Override
    public int update(Coupon coupon) {
        return couponMapper.update(coupon);
    }

    @Override
    public List<Coupon> selectByState(Integer state) {
        return couponMapper.selectByState(state);
    }
}
