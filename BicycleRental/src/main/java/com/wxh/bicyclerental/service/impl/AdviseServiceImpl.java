package com.wxh.bicyclerental.service.impl;

import com.wxh.bicyclerental.entity.Advise;
import com.wxh.bicyclerental.mapper.AdviseMapper;
import com.wxh.bicyclerental.service.IAdviseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdviseServiceImpl implements IAdviseService {

    @Autowired
    private AdviseMapper adviseMapper;

    @Override
    public List<Advise> select(Integer state) {
        return adviseMapper.select(state);
    }

    @Override
    public int insert(Advise advise) {
        return adviseMapper.insert(advise);
    }

    @Override
    public int delete(Integer id) {
        return adviseMapper.delete(id);
    }
}
