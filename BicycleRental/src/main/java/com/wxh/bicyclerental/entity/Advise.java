package com.wxh.bicyclerental.entity;

import java.io.Serializable;

/**
 * @author xhwang
 * 投诉意见表
 */
public class Advise implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 投诉类别（1：自行车，2：系统，3：服务）
     */
    private Integer type;

    /**
     * 具体描述
     */
    private String describe;

    /**
     * 外键user表
     */
    private Integer userId;

    /**
     * 状态（0:未处理，1:已处理）
     */
    private Integer state;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
