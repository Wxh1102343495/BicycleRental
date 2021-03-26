package com.wxh.bicyclerental.entity;

import java.io.Serializable;

public class ErrorInfo implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 自行车编码id
     */
    private Integer bicycleId;

    /**
     * 所在停车点
     */
    private Integer locationId;

    /**
     * 故障描述
     */
    private String describe;

    /**
     * 状态（0：已完成，1：需要维修）
     */
    private Integer state;

    /**
     * 关联自行车
     */
    private Bicycle bicycle;

    /**
     * 关联用户
     */
    private User user;

    /**
     * 关联地址
     */
    private Location location;

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Bicycle getBicycle() {
        return bicycle;
    }

    public void setBicycle(Bicycle bicycle) {
        this.bicycle = bicycle;
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

    public Integer getBicycleId() {
        return bicycleId;
    }

    public void setBicycleId(Integer bicycleId) {
        this.bicycleId = bicycleId;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ErrorInfo{" +
                "id=" + id +
                ", userId=" + userId +
                ", bicycleId=" + bicycleId +
                ", locationId=" + locationId +
                ", describe='" + describe + '\'' +
                ", state=" + state +
                '}';
    }
}
