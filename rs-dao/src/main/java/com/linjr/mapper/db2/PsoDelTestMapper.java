package com.linjr.mapper.db2;

import com.linjr.entity.db2.PsoDelTest;

import java.util.List;

public interface PsoDelTestMapper {
    int insert(PsoDelTest record);

    int insertSelective(PsoDelTest record);

    List<PsoDelTest> select1000W();

    int batchInsertList(List<PsoDelTest> list);

    int batchInsertList2(List<PsoDelTest> list);
}