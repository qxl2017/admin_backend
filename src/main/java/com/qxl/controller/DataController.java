package com.qxl.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.qxl.entity.ContactDetail;
import com.qxl.entity.MainData;
import com.qxl.entity.OperateAuth;
import com.qxl.entity.PhoneBook;
import com.qxl.service.ContactDetailService;
import com.qxl.service.MainDataService;
import com.qxl.service.OperateAuthService;
import com.qxl.service.PhoneBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2018/3/28 0028.
 */
@Controller
@RequestMapping("/data")
public class DataController {

    @Autowired
    private MainDataService mainDataService;

    @Autowired
    private PhoneBookService phoneBookService;

    @Autowired
    private ContactDetailService contactDetailService;

    @Autowired
    private OperateAuthService operateAuthService;

    @RequestMapping("/add")
    @ResponseBody
    public Map<String, Object> add(@RequestParam String name, @RequestParam String mobile, @RequestParam String idCardNo,
                                   @RequestParam String zhimaScore, @RequestParam(required = false) String debug,
                                   @RequestParam String phoneBooks, @RequestParam String all_contact_detail,
                                   @RequestParam String basicInfoVO, @RequestParam(required = false) String extendedParam){
        Map<String, Object> result = new HashMap<>();
        try {
            //根据身份证号去重,库里已有的数据不再插入
            if (!StringUtils.isEmpty(idCardNo)) {
                MainData mainData = mainDataService.selectByIdCardNo(idCardNo);
                if (mainData == null) {
                    String dataId = UUID.randomUUID().toString().replaceAll("-", "");
                    mainData = new MainData();
                    mainData.setSensorDataId(dataId);
                    mainData.setIdCard(idCardNo);
                    mainData.setName(name);
                    mainData.setMobile(mobile);
                    mainData.setZhimaScore(Integer.valueOf(zhimaScore));
                    int i = mainDataService.insert(mainData);
                    if (i > 0){
                        //插入用户联系人数据
                        String phoneBookData = phoneBooks.replaceAll("name", "nickname")
                                .replaceAll("phone", "mobile");
                        List<PhoneBook> phoneBookList = JSON.parseArray(phoneBookData, PhoneBook.class);
                        if (!CollectionUtils.isEmpty(phoneBookList)){
                            for (PhoneBook phoneBook : phoneBookList){
                                phoneBook.setMainDataId(dataId);
                            }
                            int p = phoneBookService.batchInsert(phoneBookList);
                            System.out.println("p is " + p);
                        }
                        //插入用户运营商数据
                        String contactDetailData = all_contact_detail.replaceAll("contact_number", "contactMobile")
                                .replaceAll("contact_area", "contactArea")
                                .replaceAll("call_count_6month", "callCount6month");
                        List<ContactDetail> contactDetailList = JSON.parseArray(contactDetailData, ContactDetail.class);
                        if (!CollectionUtils.isEmpty(phoneBookList)){
                            for (ContactDetail contactDetail : contactDetailList){
                                contactDetail.setMainDataId(dataId);
                            }
                            int c = contactDetailService.batchInsert(contactDetailList);
                            System.out.println("c is " + c);
                        }
                        //插入运营商认证
                        String operateAuthData = basicInfoVO.replaceAll("realName", "name")
                                .replaceAll("idCardNo", "idCard");
                        OperateAuth operateAuth = JSON.parseObject(operateAuthData, OperateAuth.class);
                        int o = operateAuthService.insert(operateAuth);
                        System.out.println("o is " + o);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    @RequestMapping("/listpage")
    @ResponseBody
    public Map<String, Object> dataList(@RequestParam Integer currentPage, @RequestParam Integer pageSize){
        Map<String, Object> result = new HashMap<>();
        try {
            Page<Map<String, Object>> pageInfo = mainDataService.getMainDataList(currentPage, pageSize);
            result.put("mainData", pageInfo.getResult());
            result.put("total", pageInfo.getTotal());
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
