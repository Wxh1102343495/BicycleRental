package com.wxh.bicyclerental.mapper;

import com.wxh.bicyclerental.entity.UserCoupon;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserCouponMapper {
    public List<UserCoupon> selectCouponByUserName(String username);
    public Integer selectByUidAndCid(UserCoupon userCoupon);
    public int insert(UserCoupon userCoupon);
    public int delete(Integer id);
}
