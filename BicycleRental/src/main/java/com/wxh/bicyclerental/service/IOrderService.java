package com.wxh.bicyclerental.service;

import com.wxh.bicyclerental.entity.Order;

import java.util.List;

public interface IOrderService {
    public Order selectOne(Integer orderId);
    public List<Order> selectByState(Integer state);
    public int insert(Order order);
    public int updateOrderEnd(Integer orderId);
}
