package com.qxl.mapper;

import com.github.pagehelper.Page;
import com.qxl.entity.MainData;
import java.util.List;
import java.util.Map;

public interface MainDataMapper {
    int deleteByPrimaryKey(String sensorDataId);

    int insert(MainData record);

    MainData selectByPrimaryKey(String sensorDataId);

    List<MainData> selectAll();

    int updateByPrimaryKey(MainData record);

    MainData selectByIdCardNo(String idCardNo);

    Page<Map<String, Object>> getMainDataList();
}