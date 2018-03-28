package com.qxl.service;

import com.github.pagehelper.Page;
import com.qxl.entity.MainData;

import java.util.Map;

/**
 * Created by Administrator on 2018/3/28 0028.
 */
public interface MainDataService {
    int insert(MainData mainData) throws Exception;

    MainData selectByIdCardNo(String idCardNo) throws Exception;

    Page<Map<String, Object>> getMainDataList(Integer pageNo, Integer pageSize) throws Exception;
}
