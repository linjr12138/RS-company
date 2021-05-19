package com.linjr.service;

import com.linjr.entity.db1.Region;
import com.linjr.vo.req.RegionAddReqVO;
import com.linjr.vo.resp.RegionRespNodeVO;

import java.util.List;

public interface RegionService {
    List<Region> selectAll();

    List<RegionRespNodeVO> regionTreeList(String regionId);

    List<Region> regionInfo();

    void regionAdd(RegionAddReqVO vo);

}
