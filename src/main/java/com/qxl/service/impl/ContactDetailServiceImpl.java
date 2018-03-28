package com.qxl.service.impl;

import com.qxl.entity.ContactDetail;
import com.qxl.mapper.ContactDetailMapper;
import com.qxl.service.ContactDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/3/28 0028.
 */
@Service
public class ContactDetailServiceImpl implements ContactDetailService {

    @Autowired
    private ContactDetailMapper contactDetailMapper;

    @Override
    public int batchInsert(List<ContactDetail> contactDetails) throws Exception {
        return contactDetailMapper.batchInsert(contactDetails);
    }
}
