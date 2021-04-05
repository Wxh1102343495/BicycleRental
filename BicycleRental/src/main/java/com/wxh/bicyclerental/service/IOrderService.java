package com.wxh.bicyclerental.service;

import com.wxh.bicyclerental.entity.Order;

import java.util.List;

public interface IOrderService {
    public Order selectOne(Integer userId);
    public List<Order> selectByState(Integer state);
    public List<Order> selectAll();
    public List<Order> selectNeedReturnPay();
    public int insert(Order order);
    public int updateOrderIng(Order order);
    public int updateOrderEnd(Integer orderId);
    public List<Order> selectByUserAndState(Order order);
    public int delete(Integer orderId);
    public int updateNeedReturnPay(Order order);
    public int updateReturnPayOk(Integer orderId);
}
