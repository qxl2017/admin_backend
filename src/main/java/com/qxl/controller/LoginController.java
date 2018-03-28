package com.qxl.controller;

import com.qxl.entity.User;
import com.qxl.service.LoginService;
import com.qxl.util.SmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/13 0013.
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(@RequestParam String mobile, @RequestParam String password) {
        Map<String, Object> result = new HashMap<>();
        try {
            if (!StringUtils.isEmpty(mobile) && !StringUtils.isEmpty(password)) {
                User user = loginService.login(mobile, password);
                if (user != null) {
                    result.put("code", 200);
                    result.put("msg", "请求成功");
                    result.put("user", user);
                } else {
                    result.put("code", 401);
                    result.put("msg", "用户名或密码错误");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            result.put("code", 500);
            result.put("msg", "系统异常");
        }
        return result;
    }

    @RequestMapping(value = "/msgSend", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> msgSend(@RequestParam String mobile){
        Map<String, Object> result = new HashMap<>();
        try {
            String vcode = createRandomVcode();
//            SmsUtil.sendSms(mobile, "智能管理后台", "SMS_128660007", "{\"code\":" + vcode + "}");
            SmsUtil.sendSmsByYunPian(mobile, "您的验证码是" + vcode + "。如非本人操作，请忽略本短信");
            System.out.println(vcode);
            result.put("vcode", vcode);
            result.put("code", 200);
            result.put("msg", "请求成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", 500);
            result.put("msg", "系统异常");
        }
        return result;
    }

    public static String createRandomVcode(){
        //验证码
        String vcode = "";
        for (int i = 0; i < 6; i++) {
            vcode = vcode + (int)(Math.random() * 9);
        }
        return vcode;
    }
}
