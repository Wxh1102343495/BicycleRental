package com.wxh.bicyclerental.service.impl;

import com.wxh.bicyclerental.entity.User;
import com.wxh.bicyclerental.mapper.UserMapper;
import com.wxh.bicyclerental.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectOne(Integer id) {
        return userMapper.selectOne(id);
    }

    @Override
    public List<User> select() {
        return userMapper.select();
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int delete(Integer id) {
        return userMapper.delete(id);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int updateIdentity(User user) {
        return userMapper.updateIdentity(user);
    }

    @Override
    public User selectByUserName(String userName) {
        return userMapper.selectByUserName(userName);
    }

    @Override
    public List<User> selectUserByIdentity(String identity) {
        return userMapper.selectUserByIdentity(identity);
    }
}
