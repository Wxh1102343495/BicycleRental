package com.wxh.bicyclerental.entity;

import java.io.Serializable;

/**
 * @author xhwang
 * 用户和优惠券中间表
 */
public class UserCoupon implements Serializable {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 优惠券id
     */
    private Long couponId;

    /**
     * 优惠券状态(1:未使用，0:已使用，2:未支付)
     */
    private Integer state;

    /**
     * 外键优惠券
     */
    private Coupon coupon;

    /**
     * 外键用户
     */
    private User user;

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
