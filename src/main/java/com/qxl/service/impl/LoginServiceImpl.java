package com.qxl.service.impl;

import com.qxl.entity.User;
import com.qxl.mapper.UserMapper;
import com.qxl.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/3/27 0027.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) throws Exception {
        User user = new User();
        user.setMobile(username);
        user.setPassword(password);
        return userMapper.loginValidate(user);
    }
}
