package com.linjr.mapper.db2;

import com.linjr.entity.db2.BaseProductSize;

import java.util.List;

public interface BaseProductSizeMapper {
    int deleteByPrimaryKey(String sizeclass);

    int insert(BaseProductSize record);

    int insertSelective(BaseProductSize record);

    BaseProductSize selectByPrimaryKey(String sizeclass);

    int updateByPrimaryKeySelective(BaseProductSize record);

    int updateByPrimaryKeyWithBLOBs(BaseProductSize record);

    int updateByPrimaryKey(BaseProductSize record);

    List<BaseProductSize> selectAssociationSize();


}