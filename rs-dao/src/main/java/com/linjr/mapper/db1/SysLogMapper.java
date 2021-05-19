package com.linjr.mapper.db1;


import com.linjr.entity.db1.SysLog;
import com.linjr.vo.req.SysLogPageReqVO;

import java.util.List;

public interface SysLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    SysLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKey(SysLog record);

    List<String> selectAll(SysLogPageReqVO vo);

    int batchDeletedLog(List<String> logIds);
}