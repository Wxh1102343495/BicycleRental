package com.wxh.bicyclerental.mapper;

import com.wxh.bicyclerental.entity.UserCoupon;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserCouponMapper {
    public List<UserCoupon> selectCouponByUserName(String username);
    public Integer selectByUidAndCid(UserCoupon userCoupon);
    public Integer selectByCouponId(Long couponId);
    public UserCoupon selectByUserId(Integer userId);
    public List<UserCoupon> selectAll(String username);
    public int insert(UserCoupon userCoupon);
    public int delete(Integer id);
    public int updateState(Integer id);
}
