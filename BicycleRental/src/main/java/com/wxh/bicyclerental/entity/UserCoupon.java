package com.wxh.bicyclerental.entity;

import java.io.Serializable;

public class UserCoupon implements Serializable {
    private Integer id;
    //用户id
    private Integer userId;
    //优惠券id
    private Integer couponId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    @Override
    public String toString() {
        return "UserCoupon{" +
                "id=" + id +
                ", userId=" + userId +
                ", couponId=" + couponId +
                '}';
    }
}
