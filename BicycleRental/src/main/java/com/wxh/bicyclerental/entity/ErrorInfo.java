package com.wxh.bicyclerental.entity;

import java.io.Serializable;

public class ErrorInfo implements Serializable {

    private Integer id;
    //用户id
    private Integer userId;
    //自行车编码id
    private Integer bicycleId;
    //故障描述
    private String describe;
    //状态（0已完成，1需要维修）
    private Integer state;

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
                ", describe='" + describe + '\'' +
                ", state=" + state +
                '}';
    }
}
