package com.linjr.service;

import com.linjr.entity.db1.SysDept;
import com.linjr.vo.req.DeptAddReqVO;
import com.linjr.vo.req.DeptUpdateReqVO;
import com.linjr.vo.resp.DeptRespNodeVO;

import java.util.List;

public interface DeptService {
    List<SysDept> selectAll();

    List<DeptRespNodeVO> deptTreeList(String deptId);

    SysDept addDept(DeptAddReqVO vo);

    void updateDept(DeptUpdateReqVO vo);

    void deletedDept(String id);
}
