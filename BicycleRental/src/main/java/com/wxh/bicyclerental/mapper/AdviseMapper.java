package com.wxh.bicyclerental.mapper;

import com.wxh.bicyclerental.entity.Advise;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdviseMapper {
    public List<Advise> select(Integer state);
    public int insert(Advise advise);
    public int delete(Integer id);
}
