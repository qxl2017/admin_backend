package com.qxl.service;

import com.qxl.entity.PhoneBook;

import java.util.List;

/**
 * Created by Administrator on 2018/3/28 0028.
 */
public interface PhoneBookService {
    int batchInsert(List<PhoneBook> phoneBooks);
}
