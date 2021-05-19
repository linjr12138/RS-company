package com.linjr.mapper.db1;



import com.linjr.entity.db1.Region;

import java.util.List;

public interface RegionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Region record);

    int insertSelective(Region record);

    Region selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Region record);

    int updateByPrimaryKey(Region record);

    List<Region> selectAll();
}