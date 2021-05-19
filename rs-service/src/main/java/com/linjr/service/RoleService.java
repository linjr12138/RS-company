package com.linjr.service;

import com.linjr.entity.db1.SysRole;
import com.linjr.vo.req.AddRoleReqVO;
import com.linjr.vo.req.RolePageReqVO;
import com.linjr.vo.req.RoleUpdateReqVO;
import com.linjr.vo.resp.PageVO;

import java.util.List;

public interface RoleService {
    PageVO<SysRole> pageInfo(RolePageReqVO vo);

    SysRole addRole(AddRoleReqVO vo);

    List<SysRole> selectAll();

    SysRole detailInfo(String id);

    void updateRole(RoleUpdateReqVO vo);

    void deletedRole(String id);

    List<String> getNameByUserId(String userId);
}
