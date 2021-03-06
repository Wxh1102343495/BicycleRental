package com.wxh.bicyclerental.entity;

import java.io.Serializable;

/**
 * @author xhwang
 * 自行车表
 */
public class Bicycle implements Serializable {
    /**
     * 主键自行车编码
     */
    private Long bicycleCode;

    /**
     * 自行车名字
     */
    private String bicycleName;

    /**
     * 照片路径
     */
    private String photo;

    /**
     * 自行车描述
     */
    private String describ;

    /**
     * 时租费用
     */
    private Float hourRent;

    /**
     * 日租费用
     */
    private Float dayRent;

    /**
     * 月租费用
     */
    private Float monthRent;

    /**
     * 自行车状态（1：正常，2：报废）
     */
    private Integer state;


    public Long getBicycleCode() {
        return bicycleCode;
    }

    public void setBicycleCode(Long bicycleCode) {
        this.bicycleCode = bicycleCode;
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

    public String getDescrib() {
        return describ;
    }

    public void setDescrib(String describ) {
        this.describ = describ;
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
                ", bicycleName='" + bicycleName + '\'' +
                ", photo='" + photo + '\'' +
                ", describ='" + describ + '\'' +
                ", hourRent=" + hourRent +
                ", dayRent=" + dayRent +
                ", monthRent=" + monthRent +
                ", state=" + state +
                '}';
    }
}
