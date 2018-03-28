package com.qxl.service;

import com.qxl.entity.ContactDetail;

import java.util.List;

/**
 * Created by Administrator on 2018/3/28 0028.
 */
public interface ContactDetailService {
    int batchInsert(List<ContactDetail> contactDetails) throws Exception;
}
