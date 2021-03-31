package com.wxh.bicyclerental.service.impl;

import com.wxh.bicyclerental.entity.Order;
import com.wxh.bicyclerental.mapper.OrderMapper;
import com.wxh.bicyclerental.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order selectOne(Integer orderId) {
        return orderMapper.selectOne(orderId);
    }

    @Override
    public List<Order> selectByState(Integer state) {
        return orderMapper.selectByState(state);
    }

    @Override
    public int insert(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public int updateOrderEnd(Order order) {
        return orderMapper.updateOrderEnd(order);
    }

    @Override
    public List<Order> selectByUserAndState(Order order) {
        return orderMapper.selectByUserAndState(order);
    }

    @Override
    public int delete(Integer orderId) {
        return orderMapper.delete(orderId);
    }
}
