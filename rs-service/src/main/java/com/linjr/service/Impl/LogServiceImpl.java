package com.linjr.service.Impl;

import com.github.pagehelper.PageHelper;
import com.linjr.entity.db1.SysLog;
import com.linjr.exception.BusinessException;
import com.linjr.exception.code.BaseResponseCode;
import com.linjr.mapper.db1.SysLogMapper;
import com.linjr.service.LogService;
import com.linjr.utils.PageUtil;
import com.linjr.vo.req.SysLogPageReqVO;
import com.linjr.vo.resp.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public PageVO<SysLog> pageInfo(SysLogPageReqVO vo) {
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        return PageUtil.getPage(sysLogMapper.selectAll(vo));
    }

    @Override
    public void deletedLog(List<String> logIds) {
        int i = sysLogMapper.batchDeletedLog(logIds);
        if (i == 0) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
    }
}
