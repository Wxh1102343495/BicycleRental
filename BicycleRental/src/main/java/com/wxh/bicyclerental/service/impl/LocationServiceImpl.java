package com.wxh.bicyclerental.service.impl;

import com.wxh.bicyclerental.entity.Location;
import com.wxh.bicyclerental.mapper.LocationMapper;
import com.wxh.bicyclerental.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements ILocationService {

    @Autowired
    private LocationMapper locationMapper;

    @Override
    public Location selectOne(Integer id) {
        return locationMapper.selectOne(id);
    }

    @Override
    public List<Location> select() {
        return locationMapper.select();
    }

    @Override
    public int insert(Location location) {
        return locationMapper.insert(location);
    }

    @Override
    public int delete(Integer id) {
        return locationMapper.delete(id);
    }

    @Override
    public int update(Location location) {
        return 0;
    }

    @Override
    public int removeLocation(Integer id) {
        return locationMapper.removeLocation(id);
    }
}
