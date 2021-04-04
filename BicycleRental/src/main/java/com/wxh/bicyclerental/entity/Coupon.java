package com.wxh.bicyclerental.entity;

import java.io.Serializable;

public class Coupon implements Serializable {
    /**
     * 主键优惠券id
     */
    private Long couponId;

    /**
     * 优惠券名字
     */
    private String couponName;

    /**
     * 优惠券描述
     */
    private String couponDescribe;

    /**
     * 折扣
     */
    private Float discount;

    /**
     * 价格
     */
    private Float price;

    /**
     * 优惠券状态（0：已下架，1：在售）
     */
    private Integer state;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getCouponDescribe() {
        return couponDescribe;
    }

    public void setCouponDescribe(String couponDescribe) {
        this.couponDescribe = couponDescribe;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "couponId=" + couponId +
                ", couponName='" + couponName + '\'' +
                ", couponDescribe='" + couponDescribe + '\'' +
                ", discount=" + discount +
                ", price=" + price +
                '}';
    }
}
