package com.linjr.service.Impl;

import com.github.pagehelper.PageHelper;
import com.linjr.entity.db1.IpadManager;
import com.linjr.entity.db1.Region;
import com.linjr.exception.BusinessException;
import com.linjr.exception.code.BaseResponseCode;
import com.linjr.mapper.db1.IpadManagerMapper;
import com.linjr.mapper.db1.RegionMapper;
import com.linjr.service.IPADManagerService;
import com.linjr.utils.PageUtil;
import com.linjr.vo.req.IPADAddReqVO;
import com.linjr.vo.req.IPADUpdateReqVO;
import com.linjr.vo.req.IpadManagerPageReqVO;
import com.linjr.vo.resp.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class IPADManagerServiceImpl implements IPADManagerService {

    @Autowired
    private IpadManagerMapper ipadManagerMapper;

    @Autowired
    private RegionMapper regionMapper;

    @Override
    public PageVO<IpadManager> pageInfo(IpadManagerPageReqVO vo) {
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        List<IpadManager> list = ipadManagerMapper.selectAll(vo);
        for (IpadManager ipadManager : list) {
            Region region = regionMapper.selectByPrimaryKey(ipadManager.getRegionId());
            if (region != null) {
                ipadManager.setRegionName(region.getRegionname());
            }
        }
        return PageUtil.getPage(list);
    }

    @Override
    public void IPADAdd(IPADAddReqVO vo) {
        IpadManager ipadManager = new IpadManager();
        BeanUtils.copyProperties(vo, ipadManager);
        ipadManager.setId(UUID.randomUUID().toString());
        ipadManager.setCreateTime(new Date());
        int i = ipadManagerMapper.insertSelective(ipadManager);
        if (i != 1) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
    }

    @Override
    public void IPADUpadteInfo(IPADUpdateReqVO vo) {
        IpadManager ipadManager = ipadManagerMapper.selectByPrimaryKey(vo.getId());
        if (ipadManager == null) {
            log.error("传入的ID不合法:{}", vo.getId());
            throw new BusinessException(BaseResponseCode.DATA_ERROR);
        }
        BeanUtils.copyProperties(vo, ipadManager);
        ipadManager.setUpdateTime(new Date());
        int i = ipadManagerMapper.updateByPrimaryKeySelective(ipadManager);
        if (i != 1) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
    }

    @Override
    public void DeletedIPAD(List<String> ids) {
        IpadManager ipadManager = new IpadManager();
        ipadManager.setUpdateTime(new Date());
        int i = ipadManagerMapper.deletedIPADs(ipadManager, ids);
        if (i == 0) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
    }
}
