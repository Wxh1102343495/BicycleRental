package com.wxh.bicyclerental.service;

import com.wxh.bicyclerental.entity.Bicycle;

import java.util.List;

public interface IBicycleService {
    public Bicycle selectOne(Integer bicycleCode);
    public List<Bicycle> select();
    public int insert(Bicycle bicycle);
    public int delete(Integer bicycleCode);
    public int update(Bicycle bicycle);
}
