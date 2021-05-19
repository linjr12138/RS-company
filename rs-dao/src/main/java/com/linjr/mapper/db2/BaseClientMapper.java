package com.linjr.mapper.db2;


import com.linjr.entity.db2.BaseClient;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BaseClientMapper {
    int deleteByPrimaryKey(String clientcode);

    int insert(BaseClient record);

    int insertSelective(BaseClient record);

    BaseClient selectByPrimaryKey(String clientcode);

    int updateByPrimaryKeySelective(BaseClient record);

    int updateByPrimaryKeyWithBLOBs(BaseClient record);

    int updateByPrimaryKey(BaseClient record);

    List<BaseClient> selectAll();
}