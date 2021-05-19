package com.linjr.service;

import com.linjr.entity.db1.SysPermission;
import com.linjr.vo.req.PermissionAddReqVO;
import com.linjr.vo.req.PermissionUpdateReqVO;
import com.linjr.vo.resp.PermissionRespNodeVO;

import java.util.List;

public interface PermissionService {
    List<SysPermission> selectAll();

    List<PermissionRespNodeVO> selectAllMenuTree();

    SysPermission addPermission(PermissionAddReqVO vo);

    List<PermissionRespNodeVO> permissionTreeList(String userID);

    List<PermissionRespNodeVO> selectAllTree();

    void updatePermission(PermissionUpdateReqVO vo);

    void deletedPermission(String permissionId);

    List<String> getPermissionByUserId(String userId);

    List<SysPermission> getPermissions(String userId);
}
