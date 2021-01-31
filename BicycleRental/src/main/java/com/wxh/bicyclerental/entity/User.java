package com.wxh.bicyclerental.entity;

public class User {
    //主键
    private Integer id;
    //用户名
    private String username;
    //密码
    private String password;
    //身份（sys/user）
    private String identity;
    //姓名
    private String name;
    //身份证号
    private String idNumber;
    //电话号
    private Integer phoneNumber;
    //电子邮箱
    private String email;
    //状态（0/1）
    private Integer state;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getIdentity() {
        return this.identity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdNumber() {
        return this.idNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getPhoneNumber() {
        return this.phoneNumber;
    }



    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }



    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getState() {
        return this.state;
    }
}
