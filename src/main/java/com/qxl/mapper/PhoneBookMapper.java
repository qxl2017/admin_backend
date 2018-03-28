package com.qxl.mapper;

import com.qxl.entity.PhoneBook;
import java.util.List;

public interface PhoneBookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PhoneBook record);

    PhoneBook selectByPrimaryKey(Integer id);

    List<PhoneBook> selectAll();

    int updateByPrimaryKey(PhoneBook record);

    int batchInsert(List<PhoneBook> bookList);
}