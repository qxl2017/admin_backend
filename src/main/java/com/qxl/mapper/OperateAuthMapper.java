package com.qxl.mapper;

import com.qxl.entity.OperateAuth;
import java.util.List;

public interface OperateAuthMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OperateAuth record);

    OperateAuth selectByPrimaryKey(Integer id);

    List<OperateAuth> selectAll();

    int updateByPrimaryKey(OperateAuth record);
}