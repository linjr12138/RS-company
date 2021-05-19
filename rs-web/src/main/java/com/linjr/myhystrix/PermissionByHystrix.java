package com.linjr.myhystrix;

import com.linjr.entity.db1.SysPermission;
import com.linjr.exception.BusinessException;
import com.linjr.exception.code.BaseResponseCode;
import com.linjr.myfeign.PerMissionByFeign;
import com.linjr.utils.DataResult;
import com.linjr.vo.req.PermissionAddReqVO;
import com.linjr.vo.req.PermissionUpdateReqVO;
import com.linjr.vo.resp.PermissionRespNodeVO;

import javax.validation.Valid;
import java.util.List;

public class PermissionByHystrix implements PerMissionByFeign {
    @Override
    public DataResult<List<SysPermission>> getAllPermission() {
        throw new BusinessException(BaseResponseCode.SYSTEM_ERROR);
    }

    @Override
    public DataResult<List<PermissionRespNodeVO>> getAllPermissionTreeExBtn() {
        throw new BusinessException(BaseResponseCode.SYSTEM_ERROR);
    }

    @Override
    public DataResult<SysPermission> addPermission(@Valid PermissionAddReqVO vo) {
        throw new BusinessException(BaseResponseCode.SYSTEM_ERROR);
    }

    @Override
    public DataResult<List<PermissionRespNodeVO>> getAllPermissionTree() {
        throw new BusinessException(BaseResponseCode.SYSTEM_ERROR);
    }

    @Override
    public DataResult updatePermission(@Valid PermissionUpdateReqVO vo) {
        throw new BusinessException(BaseResponseCode.SYSTEM_ERROR);
    }

    @Override
    public DataResult deletedPermission(String permissionId) {
        throw new BusinessException(BaseResponseCode.SYSTEM_ERROR);
    }
}
