package com.wxh.bicyclerental.mapper;

import com.wxh.bicyclerental.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
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
