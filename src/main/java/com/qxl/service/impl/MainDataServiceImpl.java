package com.qxl.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qxl.entity.MainData;
import com.qxl.mapper.MainDataMapper;
import com.qxl.service.MainDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Administrator on 2018/3/28 0028.
 */
@Service
public class MainDataServiceImpl implements MainDataService{

    @Autowired
    private MainDataMapper mainDataMapper;

    @Override
    public int insert(MainData mainData) throws Exception {
        return mainDataMapper.insert(mainData);
    }

    @Override
    public MainData selectByIdCardNo(String idCardNo) throws Exception {
        return mainDataMapper.selectByIdCardNo(idCardNo);
    }

    @Override
    public Page<Map<String, Object>> getMainDataList(Integer pageNo, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNo, pageSize);
        return mainDataMapper.getMainDataList();
    }
}
