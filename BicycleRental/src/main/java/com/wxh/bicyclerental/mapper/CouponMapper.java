package com.wxh.bicyclerental.mapper;

import com.wxh.bicyclerental.entity.Coupon;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CouponMapper {
    public Coupon selectOne();
    public List<Coupon> select();
    public int insert(Coupon coupon);
    public int delete(Integer id);
    public int update(Coupon coupon);
    public List<Coupon> selectByState(Integer state);
}
