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
     * 所在位置（根据定位显示）
     */
    private String location;

    /**
     * 故障描述
     */
    private String describe;

    /**
     * 状态（0：已完成，1：需要维修）
     */
    private Integer state;

    /**
     * 故障照片1
     */
    private String photoOne;

    /**
     * 故障照片2
     */
    private String photoTwo;

    /**
     * 关联自行车
     */
    private Bicycle bicycle;

    /**
     * 关联用户
     */
    private User user;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public String getPhotoOne() {
        return photoOne;
    }

    public void setPhotoOne(String photoOne) {
        this.photoOne = photoOne;
    }

    public String getPhotoTwo() {
        return photoTwo;
    }

    public void setPhotoTwo(String photoTwo) {
        this.photoTwo = photoTwo;
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

    @Override
    public String toString() {
        return "ErrorInfo{" +
                "id=" + id +
                ", userId=" + userId +
                ", bicycleId=" + bicycleId +
                ", location='" + location + '\'' +
                ", describe='" + describe + '\'' +
                ", state=" + state +
                ", photoOne='" + photoOne + '\'' +
                ", photoTwo='" + photoTwo + '\'' +
                '}';
    }
}
