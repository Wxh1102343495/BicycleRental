package com.wxh.bicyclerental.service;

import com.wxh.bicyclerental.entity.ErrorInfo;

import java.util.List;

public interface IErrorInfoService {
    public List<ErrorInfo> select();
    public ErrorInfo selectOne(Integer id);
    public int insert(ErrorInfo errorInfo);
    public int editErrorInfoState(Integer id);
}
