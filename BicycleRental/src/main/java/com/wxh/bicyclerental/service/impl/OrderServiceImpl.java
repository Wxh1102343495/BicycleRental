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
    public Order selectOne(Integer userId) {
        return orderMapper.selectOne(userId);
    }

    @Override
    public List<Order> selectByState(Integer state) {
        return orderMapper.selectByState(state);
    }

    @Override
    public List<Order> selectAll() {
        return orderMapper.selectAll();
    }

    @Override
    public List<Order> selectNeedReturnPay() {
        return orderMapper.selectNeedReturnPay();
    }

    @Override
    public int insert(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public int updateOrderIng(Order order) {
        return orderMapper.updateOrderIng(order);
    }

    @Override
    public int updateOrderEnd(Integer orderId) {
        return orderMapper.updateOrderEnd(orderId);
    }

    @Override
    public List<Order> selectByUserAndState(Order order) {
        return orderMapper.selectByUserAndState(order);
    }

    @Override
    public int delete(Integer orderId) {
        return orderMapper.delete(orderId);
    }

    @Override
    public int updateNeedReturnPay(Order order) {
        return orderMapper.updateNeedReturnPay(order);
    }

    @Override
    public int updateReturnPayOk(Integer orderId) {
        return orderMapper.updateReturnPayOk(orderId);
    }
}
