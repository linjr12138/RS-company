package com.linjr.service.Impl;

import com.linjr.entity.db1.IpadManager;
import com.linjr.entity.db1.Region;
import com.linjr.exception.BusinessException;
import com.linjr.exception.code.BaseResponseCode;
import com.linjr.mapper.db1.IpadManagerMapper;
import com.linjr.mapper.db1.RegionMapper;
import com.linjr.service.RegionService;
import com.linjr.vo.req.RegionAddReqVO;
import com.linjr.vo.resp.RegionRespNodeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    private RegionMapper regionMapper;

    @Autowired
    private IpadManagerMapper ipadManagerMapper;

    @Override
    public List<Region> selectAll() {
        List<Region> list = regionMapper.selectAll();
        for (Region s : list) {
            Region parent = regionMapper.selectByPrimaryKey(s.getPid());
            if (parent != null) {
                s.setPidName(s.getRegionname());
            }
        }
        return list;
    }

    @Override
    public List<RegionRespNodeVO> regionTreeList(String regionId) {
        List<Region> list = regionMapper.selectAll();
        RegionRespNodeVO respNodeVO = new RegionRespNodeVO();
        respNodeVO.setId("0");
        respNodeVO.setTitle("默认顶级区域");
        respNodeVO.setChildren(getTree(list));
        List<RegionRespNodeVO> result = new ArrayList<>();
        result.add(respNodeVO);
        return result;
    }


    @Override
    public List<Region> regionInfo() {
        List<IpadManager> ipadManagerList = ipadManagerMapper.selectAlls();
        List<Region> regionList = selectAll();
        List<Region> list = new ArrayList<>();
        for (Region region : regionList) {
            Integer ipadsum = 0;//IPAD总数
            Integer borrowedIAPD = 0;
            Integer borrowedCharger = 0;
            Integer borrowedChargingLine = 0;
            Integer returnIAPD = 0;
            Integer returnCharger = 0;
            Integer returnChargingLine = 0;
            for (IpadManager ipadManager : ipadManagerList) {
                if (ipadManager.getRegionId().equals(region.getId())) {
                    ipadsum += ipadManager.getIpadsum();
                    if (ipadManager.getBorrowReturn() == 1) {//借出
                        borrowedCharger += ipadManager.getCharger();
                        borrowedChargingLine += ipadManager.getChargingLine();
                        borrowedIAPD += ipadManager.getIpadsum();
                    }
                    if (ipadManager.getBorrowReturn() == 2) {//已还
                        returnIAPD += ipadManager.getIpadsum();
                        returnCharger += ipadManager.getCharger();
                        returnChargingLine += ipadManager.getChargingLine();
                    }
                }
            }
            region.setBorrowedIAPD(borrowedIAPD);
            region.setBorrowedCharger(borrowedCharger);
            region.setBorrowedChargingLine(borrowedChargingLine);

            region.setReturnIAPD(returnIAPD);
            region.setReturnCharger(returnCharger);
            region.setReturnChargingLine(returnChargingLine);

            region.setNotYetIAPD(returnIAPD - borrowedIAPD);
            region.setNotYetCharger(returnCharger - borrowedCharger);
            region.setNotYetChargingLine(returnChargingLine - borrowedChargingLine);
            list.add(region);
        }
        return list;
    }

    @Override
    public void regionAdd(RegionAddReqVO vo) {
        Region region = new Region();
        BeanUtils.copyProperties(vo, region);
        region.setId(UUID.randomUUID().toString());
        region.setCreateTime(new Date());
        int i = regionMapper.insertSelective(region);
        if (i != 1) {
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
    }

    private List<RegionRespNodeVO> getTree(List<Region> all) {
        List<RegionRespNodeVO> list = new ArrayList<>();
        for (Region s :
                all) {
            if (s.getPid().equals("0")) {
                RegionRespNodeVO respNodeVO = new RegionRespNodeVO();
                respNodeVO.setId(s.getId());
                respNodeVO.setTitle(s.getRegionname());
                respNodeVO.setChildren(getChild(s.getId(), all));
                list.add(respNodeVO);
            }
        }
        return list;
    }

    private List<RegionRespNodeVO> getChild(String id, List<Region> all) {
        List<RegionRespNodeVO> list = new ArrayList<>();
        for (Region s :
                all) {
            if (s.getPid().equals(id)) {
                RegionRespNodeVO regionRespNodeVO = new RegionRespNodeVO();
                regionRespNodeVO.setId(s.getId());
                regionRespNodeVO.setTitle(s.getRegionname());
                regionRespNodeVO.setChildren(getChild(s.getId(), all));
                list.add(regionRespNodeVO);
            }
        }
        return list;
    }
}
