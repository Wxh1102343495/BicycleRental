package com.wxh.bicyclerental.service;

import com.wxh.bicyclerental.entity.Location;

import java.util.List;

public interface ILocationService {
    public Location selectOne(Integer id);
    public List<Location> select();
    public int insert(Location location);
    public int delete(Integer id);
    public int update(Location location);
}
