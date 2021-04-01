package com.wxh.bicyclerental.mapper;

import com.wxh.bicyclerental.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    public Order selectOne(Integer userId);
    public List<Order> selectByState(Integer state);
    public int insert(Order order);
    public int updateOrderEnd(Order order);
    public List<Order> selectByUserAndState(Order order);
    public int delete(Integer orderId);
}
