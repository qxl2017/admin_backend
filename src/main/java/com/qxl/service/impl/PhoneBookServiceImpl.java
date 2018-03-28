package com.qxl.service.impl;

import com.qxl.entity.PhoneBook;
import com.qxl.mapper.PhoneBookMapper;
import com.qxl.service.PhoneBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/3/28 0028.
 */
@Service
public class PhoneBookServiceImpl implements PhoneBookService {

    @Autowired
    private PhoneBookMapper phoneBookMapper;

    @Override
    public int batchInsert(List<PhoneBook> phoneBooks) {
        return phoneBookMapper.batchInsert(phoneBooks);
    }
}
