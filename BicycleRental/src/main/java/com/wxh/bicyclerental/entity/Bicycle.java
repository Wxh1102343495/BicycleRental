package com.wxh.bicyclerental.entity;

import java.io.Serializable;

public class Bicycle implements Serializable {
    //自行车编码
    private Integer bicycleCode;
    //所在停车点id
    private Integer locationId;
    //自行车名字
    private String bicycleName;
    // 照片路径
    private String photo;
    //自行车描述
    private String describe;
    //时租费用
    private Float hourRent;
    //日租费用
    private Float dayRent;
    //月租费用
    private Float monthRent;
    //自行车状态（0/1/2）
    private Integer state;

    public Integer getBicycleCode() {
        return bicycleCode;
    }

    public void setBicycleCode(Integer bicycleCode) {
        this.bicycleCode = bicycleCode;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getBicycleName() {
        return bicycleName;
    }

    public void setBicycleName(String bicycleName) {
        this.bicycleName = bicycleName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Float getHourRent() {
        return hourRent;
    }

    public void setHourRent(Float hourRent) {
        this.hourRent = hourRent;
    }

    public Float getDayRent() {
        return dayRent;
    }

    public void setDayRent(Float dayRent) {
        this.dayRent = dayRent;
    }

    public Float getMonthRent() {
        return monthRent;
    }

    public void setMonthRent(Float monthRent) {
        this.monthRent = monthRent;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
    @Override
    public String toString() {
        return "Bicycle{" +
                "bicycleCode=" + bicycleCode +
                ", locationId=" + locationId +
                ", bicycleName='" + bicycleName + '\'' +
                ", photo='" + photo + '\'' +
                ", describe='" + describe + '\'' +
                ", hourRent=" + hourRent +
                ", dayRent=" + dayRent +
                ", monthRent=" + monthRent +
                ", state=" + state +
                '}';
    }
}
