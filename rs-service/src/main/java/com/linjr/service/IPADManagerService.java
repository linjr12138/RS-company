package com.linjr.service;

import com.linjr.entity.db1.IpadManager;
import com.linjr.vo.req.IPADAddReqVO;
import com.linjr.vo.req.IPADUpdateReqVO;
import com.linjr.vo.req.IpadManagerPageReqVO;
import com.linjr.vo.resp.PageVO;

import java.util.List;

public interface IPADManagerService {
    PageVO<IpadManager> pageInfo(IpadManagerPageReqVO vo);

    void IPADAdd(IPADAddReqVO vo);

    void IPADUpadteInfo(IPADUpdateReqVO vo);

    void DeletedIPAD(List<String> ids);
}
