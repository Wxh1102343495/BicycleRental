package com.wxh.bicyclerental.mapper;

import com.wxh.bicyclerental.entity.Location;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LocationMapper {
    public Location selectOne(Integer id);
    public List<Location> select();
    public int insert(Location location);
    public int delete(Integer id);
    public int update(Location location);
    public int removeLocation(Integer id);
}
