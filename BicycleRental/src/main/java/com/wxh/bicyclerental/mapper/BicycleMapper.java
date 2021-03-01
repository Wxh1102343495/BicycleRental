package com.wxh.bicyclerental.mapper;

import com.wxh.bicyclerental.entity.Bicycle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BicycleMapper {
    public Bicycle selectOne(Long bicycleCode);
    public List<Bicycle> select();
    public int insert(Bicycle bicycle);
    public int delete(Long bicycleCode);
    public int update(Bicycle bicycle);
}
