package com.linjr.mapper.db1;



import com.linjr.entity.db1.SysUserRole;

import java.util.List;

public interface SysUserRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);

    List<String> getRoleIdsByUserId(String userId);

    int batchRemoveRoleByUserId(String userId);

    int batchInsertUserRole(List<SysUserRole> list);

    List<String> getUserIdByRoleIds(List<String> roleIds);

    List<String> getUserIdByRoleId(String roleId);

    int removeByRoleId(String roleId);
}