package com.linjr.mapper.db1;



import com.linjr.entity.db1.SysRolePermission;

import java.util.List;

public interface SysRolePermissionMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

    SysRolePermission selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysRolePermission record);

    int updateByPrimaryKey(SysRolePermission record);

    int batchInsertRolePermission(List<SysRolePermission> list);

    List<String> getRoleIdByPermissionId(String permissionId);

    //根据permissionId 删除角色和菜单权限关联表相关数据
    int removeByPermissionId(String permissionId);

    //根据角色ID获取该角色关联的菜单权限Id集合
    List<String> getPermissionIdsByRoleId(String roleId);

    //根据角色id删除角色和菜单角色关联相关数据
    int removeByRoleId(String roleId);

    List<String> getPermissionIdByRoleIds(List<String> roleIds);
}