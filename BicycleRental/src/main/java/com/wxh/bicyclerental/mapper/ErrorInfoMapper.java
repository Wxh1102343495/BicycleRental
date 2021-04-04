package com.wxh.bicyclerental.mapper;

import com.wxh.bicyclerental.entity.ErrorInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ErrorInfoMapper {
    public List<ErrorInfo> select();
    public ErrorInfo selectOne(Integer id);
    public int insert(ErrorInfo errorInfo);
    public int editErrorInfoState(Integer id);
}
