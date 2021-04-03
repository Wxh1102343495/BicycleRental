package com.wxh.bicyclerental.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    /**
     * 订单编号
     */
    private Integer orderId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 优惠券id
     */
    private Integer couponId;

    /**
     * 自行车编码
     */
    private Long bicycleId;

    /**
     * 取车地点id
     */
    private Integer locationId;

    /**
     * 租赁方式（h时租，d日租，m月租）
     */
    private String rentMode;

    /**
     * 订单开始时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startTime;

    /**
     * 订单结束时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;

    /**
     * 总租金
     */
    private Float rent;

    /**
     * 订单状态（0：已完成，1：正在进行，2：未支付）
     */
    private Integer state;

    /**
     * 备注
     */
    private String remark;

    /**
     * 订单评价
     */
    private String evaluation;

    /**
     * 是否超出服务区(0:否，1:是)
     */
    private Integer isMoreFixed;

    /**
     * 关联用户
     */
    private User user;

    /**
     * 关联自行车
     */
    private Bicycle bicycle;

    /**
     * 关联地址
     */
    private Location location;

    /**
     * 关联优惠券
     */
    private Coupon coupon;


    public Integer getIsMoreFixed() {
        return isMoreFixed;
    }

    public void setIsMoreFixed(Integer isMoreFixed) {
        this.isMoreFixed = isMoreFixed;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

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

    public Bicycle getBicycle() {
        return bicycle;
    }

    public void setBicycle(Bicycle bicycle) {
        this.bicycle = bicycle;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getBicycleId() {
        return bicycleId;
    }

    public void setBicycleId(Long bicycleId) {
        this.bicycleId = bicycleId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Float getRent() {
        return rent;
    }

    public void setRent(Float rent) {
        this.rent = rent;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }
    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getRentMode() {
        return rentMode;
    }

    public void setRentMode(String rentMode) {
        this.rentMode = rentMode;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", bicycleId=" + bicycleId +
                ", locationId=" + locationId +
                ", startDate=" + startTime +
                ", rentMode='" + rentMode + '\'' +
                ", endDate=" + endTime +
                ", rent=" + rent +
                ", state=" + state +
                ", evaluation='" + evaluation + '\'' +
                '}';
    }
}
