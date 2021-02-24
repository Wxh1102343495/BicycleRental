package com.wxh.bicyclerental.mapper;

import com.wxh.bicyclerental.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public User selectOne(Integer id);
    public List<User> select();
    public int insert(User user);
    public int delete(Integer id);
    public int update(User user);
    public int updateIdentity(User user);
    public User selectByUserName(String userName);
    /**
     * 分页查询用户
     * @return
     */
    List<User> selectUserByPage();
}
