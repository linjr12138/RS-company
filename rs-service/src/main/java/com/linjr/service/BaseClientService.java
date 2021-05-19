package com.linjr.service;

import com.linjr.entity.db2.BaseClient;
import com.linjr.vo.resp.BaseClientRespNodeVO;

import java.util.List;

public interface BaseClientService {

    List<BaseClient> selectAll();

    List<BaseClientRespNodeVO> baseClientTreeList();

    List<BaseClientRespNodeVO> baseClienAllTreeList();

    BaseClient selectByClientCode(String clientcode);
}
