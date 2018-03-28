package com.qxl.service;

import com.qxl.entity.User;

/**
 * Created by Administrator on 2018/3/26 0026.
 */
public interface LoginService {
    User login(String username, String password) throws Exception;
}
