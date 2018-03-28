package com.qxl.service.impl;

import com.qxl.entity.OperateAuth;
import com.qxl.mapper.OperateAuthMapper;
import com.qxl.service.OperateAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/3/28 0028.
 */
@Service
public class OperateAuthServiceImpl implements OperateAuthService {

    @Autowired
    private OperateAuthMapper operateAuthMapper;

    @Override
    public int insert(OperateAuth operateAuth) throws Exception {
        return operateAuthMapper.insert(operateAuth);
    }
}
