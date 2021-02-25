package com.wxh.bicyclerental.service;

import com.wxh.bicyclerental.entity.User;

import java.util.List;

public interface IUserService {
    public User selectOne(Integer id);
    public List<User> select();
    public int insert(User user);
    public int delete(Integer id);
    public int update(User user);
    //修改身份为系统管理员
    public int updateIdentity(User user);
    //根据用户名查密码
    public User selectByUserName(String userName);


    /**
     * 根据权限查询用户
     * @return
     */
    List<User> selectUserByIdentity(String identity);
}
