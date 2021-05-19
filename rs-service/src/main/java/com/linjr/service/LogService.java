package com.linjr.service;

import com.linjr.entity.db1.SysLog;
import com.linjr.vo.req.SysLogPageReqVO;
import com.linjr.vo.resp.PageVO;

import java.util.List;

public interface LogService {
    PageVO<SysLog> pageInfo(SysLogPageReqVO vo);

    void deletedLog(List<String> logIds);
}
