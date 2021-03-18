package com.wxh.bicyclerental.service.impl;

import com.wxh.bicyclerental.entity.Bicycle;
import com.wxh.bicyclerental.mapper.BicycleMapper;
import com.wxh.bicyclerental.service.IBicycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BicycleServiceImpl implements IBicycleService {

    @Autowired
    private BicycleMapper bicycleMapper;

    @Override
    public Bicycle selectOne(Long bicycleCode) {
        return bicycleMapper.selectOne(bicycleCode);
    }

    @Override
    public List<Bicycle> select() {
        return bicycleMapper.select();
    }

    @Override
    public int insert(Bicycle bicycle) {
        return bicycleMapper.insert(bicycle);
    }

    @Override
    public int update(Bicycle bicycle) {
        return bicycleMapper.update(bicycle);
    }

    @Override
    public int removeBicycle(Long bicycleCode) {
        return bicycleMapper.removeBicycle(bicycleCode);
    }
}
