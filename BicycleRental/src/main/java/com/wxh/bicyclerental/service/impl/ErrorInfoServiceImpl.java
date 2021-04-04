package com.wxh.bicyclerental.service.impl;

import com.wxh.bicyclerental.entity.ErrorInfo;
import com.wxh.bicyclerental.mapper.ErrorInfoMapper;
import com.wxh.bicyclerental.service.IErrorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ErrorInfoServiceImpl implements IErrorInfoService {

    @Autowired
    private ErrorInfoMapper errorInfoMapper;

    @Override
    public List<ErrorInfo> select() {
        return errorInfoMapper.select();
    }

    @Override
    public ErrorInfo selectOne(Integer id) {
        return errorInfoMapper.selectOne(id);
    }

    @Override
    public int insert(ErrorInfo errorInfo) {
        return errorInfoMapper.insert(errorInfo);
    }

    @Override
    public int editErrorInfoState(Integer id) {
        return errorInfoMapper.editErrorInfoState(id);
    }
}
