package com.wxh.bicyclerental.service.impl;

import com.wxh.bicyclerental.entity.UserCoupon;
import com.wxh.bicyclerental.mapper.UserCouponMapper;
import com.wxh.bicyclerental.service.IUserCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserCouponServiceImpl implements IUserCouponService {

    @Autowired
    private UserCouponMapper userCouponMapper;

    @Override
    public List<UserCoupon> selectCouponByUserName(String username) {
        return userCouponMapper.selectCouponByUserName(username);
    }

    @Override
    public Integer selectByUidAndCid(UserCoupon userCoupon) {
        return userCouponMapper.selectByUidAndCid(userCoupon);
    }

    @Override
    public int insert(UserCoupon userCoupon) {
        return userCouponMapper.insert(userCoupon);
    }

    @Override
    public int delete(Integer id) {
        return userCouponMapper.delete(id);
    }
}
