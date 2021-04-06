package com.wxh.bicyclerental.service;

import com.wxh.bicyclerental.entity.Advise;

import java.util.List;

public interface IAdviseService {
    public List<Advise> select(Integer state);
    public int insert(Advise advise);
    public int delete(Integer id);
}
