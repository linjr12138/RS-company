package com.linjr.myfeign;


import com.linjr.aop.annotation.MyLog;
import com.linjr.contants.ServiceName;
import com.linjr.entity.db1.SysPermission;
import com.linjr.myhystrix.PermissionByHystrix;
import com.linjr.utils.DataResult;
import com.linjr.vo.req.PermissionAddReqVO;
import com.linjr.vo.req.PermissionUpdateReqVO;
import com.linjr.vo.resp.PermissionRespNodeVO;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient(contextId = "PermissionClient",name = ServiceName.RS_web,fallback = PermissionByHystrix.class)
public interface PerMissionByFeign {
    @GetMapping("/api/permissions")
    @ApiOperation(value = "获取所有的菜单权限")
    @MyLog(title = "组织管理-菜单权限管理", action = "获取所有的菜单权限")
    @RequiresPermissions("sys:permission:list")
    DataResult<List<SysPermission>> getAllPermission();

    @GetMapping("/api/permission/tree")
    @ApiOperation(value = "菜单权限树接口-只递归查询到菜单")
    @MyLog(title = "组织管理-菜单权限管理", action = "菜单权限树接口-只递归查询到菜单")
    @RequiresPermissions(value = {"sys:permission:update", "sys:permission:add"}, logical = Logical.OR)
    DataResult<List<PermissionRespNodeVO>> getAllPermissionTreeExBtn();

    @PostMapping("/api/permission")
    @ApiOperation(value = "新增菜单权限")
    @MyLog(title = "组织管理-菜单权限管理", action = "新增菜单权限")
    @RequiresPermissions("sys:permission:add")
    DataResult<SysPermission> addPermission(@RequestBody @Valid PermissionAddReqVO vo);

    @GetMapping("/api/permission/tree/all")
    @ApiOperation(value = "菜单权限树-递归查询所有")
    @MyLog(title = "组织管理-菜单权限管理", action = "菜单权限树-递归查询所有")
    @RequiresPermissions(value = {"sys:role:update", "sys:role:add"}, logical = Logical.OR)
    DataResult<List<PermissionRespNodeVO>> getAllPermissionTree();

    @PutMapping("/api/permission")
    @ApiOperation(value = "编辑菜单权限接口")
    @MyLog(title = "组织管理-菜单权限管理", action = "编辑菜单权限接口")
    @RequiresPermissions("sys:permission:update")
    DataResult updatePermission(@RequestBody @Valid PermissionUpdateReqVO vo);

    @DeleteMapping("/api/permission/{permissionId}")
    @ApiOperation(value = "删除菜单权限接口")
    @MyLog(title = "组织管理-菜单权限管理", action = "删除菜单权限接口")
    @RequiresPermissions("sys:permission:delete")
    DataResult deletedPermission(@PathVariable("permissionId") String permissionId);
}
