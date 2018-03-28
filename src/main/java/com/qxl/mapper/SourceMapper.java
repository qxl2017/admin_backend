package com.qxl.mapper;

import com.qxl.entity.Source;
import java.util.List;

public interface SourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Source record);

    Source selectByPrimaryKey(Integer id);

    List<Source> selectAll();

    int updateByPrimaryKey(Source record);
}