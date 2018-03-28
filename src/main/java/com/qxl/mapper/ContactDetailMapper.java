package com.qxl.mapper;

import com.qxl.entity.ContactDetail;
import java.util.List;

public interface ContactDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ContactDetail record);

    ContactDetail selectByPrimaryKey(Integer id);

    List<ContactDetail> selectAll();

    int updateByPrimaryKey(ContactDetail record);

    int batchInsert(List<ContactDetail> contactDetails);
}