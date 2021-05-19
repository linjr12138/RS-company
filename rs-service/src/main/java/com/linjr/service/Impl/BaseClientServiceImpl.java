package com.linjr.service.Impl;

import com.linjr.entity.db2.BaseClient;
import com.linjr.mapper.db2.BaseClientMapper;
import com.linjr.service.BaseClientService;
import com.linjr.vo.resp.BaseClientRespNodeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BaseClientServiceImpl implements BaseClientService {
    @Autowired
    private BaseClientMapper baseClientMapper;

    @Transactional(transactionManager = "db2TransactionManager")
    @Override
    public List<BaseClient> selectAll() {
        List<BaseClient> list = baseClientMapper.selectAll();
        if (!list.isEmpty()){
            for (BaseClient baseClient : list){
                BaseClient parent = baseClientMapper.selectByPrimaryKey(baseClient.getParentcode());
                if (parent != null){
                    baseClient.setParentname(parent.getClientname());
                }
            }
        }
        return list;
    }

    @Transactional(transactionManager = "db2TransactionManager")
    @Override
    public List<BaseClientRespNodeVO> baseClientTreeList() {
        List<BaseClient> list = baseClientMapper.selectAll();
        List<BaseClientRespNodeVO> result = new ArrayList<>();
        BaseClientRespNodeVO baseClientRespNodeVO = new BaseClientRespNodeVO();
        baseClientRespNodeVO.setClientcode("HEAD");
        baseClientRespNodeVO.setTitle("总部");
        baseClientRespNodeVO.setChildren(getTree(list,true));
        result.add(baseClientRespNodeVO);
        return result;
    }

    @Override
    public List<BaseClientRespNodeVO> baseClienAllTreeList() {
        return getTree(selectAll(),false);
    }

    @Override
    public BaseClient selectByClientCode(String clientcode) {
        return baseClientMapper.selectByPrimaryKey(clientcode);
    }

    private List<BaseClientRespNodeVO> getTree(List<BaseClient> all , boolean type){
        List<BaseClientRespNodeVO> list = new ArrayList<>();
        if (all == null || all.isEmpty()) {
            return list;
        }
        for (BaseClient baseClient : all){
            if (baseClient.getParentcode().equals("HEAD")){
                BaseClientRespNodeVO baseClientRespNodeVO = new BaseClientRespNodeVO();
                baseClientRespNodeVO.setClientcode(baseClient.getClientcode());
                baseClientRespNodeVO.setTitle(baseClient.getClientname());
                if (type){
                    baseClientRespNodeVO.setChildren(getChildDEALER(baseClient.getClientcode(),all));
                }else {
                    baseClientRespNodeVO.setChildren(getChild(baseClient.getClientcode(),all));
                }
                list.add(baseClientRespNodeVO);
            }
        }
        return list;
    }
    //递归遍历所有数据
    private List<BaseClientRespNodeVO> getChild(String clientCode ,List<BaseClient> all){
        List<BaseClientRespNodeVO> list = new ArrayList<>();
        for (BaseClient baseClient : all){
            if (baseClient.getParentcode().equals(clientCode)){
                BaseClientRespNodeVO baseClientRespNodeVO = new BaseClientRespNodeVO();
                BeanUtils.copyProperties(baseClient,baseClientRespNodeVO);
                baseClientRespNodeVO.setTitle(baseClient.getClientname());
                baseClientRespNodeVO.setChildren(getChild(baseClient.getClientcode(),all));
                list.add(baseClientRespNodeVO);
            }
        }
        return list;
    }

    //只递归到经销商
    private List<BaseClientRespNodeVO> getChildDEALER(String clientCode,List<BaseClient> all){
        List<BaseClientRespNodeVO> list = new ArrayList<>();
        for (BaseClient baseClient : all){
            if (baseClient.getParentcode().equals(clientCode) && !baseClient.getClientlevel().equals("SHOP")){
                BaseClientRespNodeVO baseClientRespNodeVO = new BaseClientRespNodeVO();
                BeanUtils.copyProperties(baseClient,baseClientRespNodeVO);
                baseClientRespNodeVO.setTitle(baseClient.getClientname());
                baseClientRespNodeVO.setChildren(getChildDEALER(baseClient.getClientcode(),all));
                list.add(baseClientRespNodeVO);
            }
        }
        return list;
    }
}
