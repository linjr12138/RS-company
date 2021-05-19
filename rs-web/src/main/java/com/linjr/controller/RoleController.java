package com.linjr.controller;


import com.linjr.aop.annotation.MyLog;
import com.linjr.entity.db1.SysRole;
import com.linjr.service.RolePermissionService;
import com.linjr.service.RoleService;
import com.linjr.utils.DataResult;
import com.linjr.vo.req.AddRoleReqVO;
import com.linjr.vo.req.RolePageReqVO;
import com.linjr.vo.req.RoleUpdateReqVO;
import com.linjr.vo.resp.PageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api")
@Api(tags = "组织管理-角色管理", description = "角色管理相关接口")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RolePermissionService rolePermissionService;

    @PostMapping("/roles")
    @ApiOperation(value = "分页获取角色数据")
    @MyLog(title = "组织管理-角色管理", action = "分页获取角色数据")
    @RequiresPermissions("sys:role:list")
    public DataResult<PageVO<SysRole>> pageInfo(@RequestBody RolePageReqVO vo) {
        DataResult result = DataResult.success();
        result.setData(roleService.pageInfo(vo));
        return result;
    }

    @PostMapping("/role")
    @ApiOperation(value = "新增角色接口")
    @MyLog(title = "组织管理-角色管理", action = "新增角色接口")
    @RequiresPermissions("sys:role:add")
    public DataResult<SysRole> addRole(@RequestBody @Valid AddRoleReqVO vo) {
        DataResult result = DataResult.success();
        result.setData(roleService.addRole(vo));
        return result;
    }

    @GetMapping("/role/{id}")
    @ApiOperation(value = "获取角色详情")
    @MyLog(title = "组织管理-角色管理", action = "获取角色详情")
    @RequiresPermissions("sys:role:detail")
    public DataResult<SysRole> detailInfo(@PathVariable("id") String id) {
        DataResult result = DataResult.success();
        result.setData(roleService.detailInfo(id));
        return result;
    }

    @PutMapping("/role")
    @ApiOperation(value = "更新角色信息接口")
    @MyLog(title = "组织管理-角色管理", action = "更新角色信息接口")
    @RequiresPermissions("sys:role:update")
    public DataResult updateRole(@RequestBody @Valid RoleUpdateReqVO vo) {
        DataResult result = DataResult.success();
        roleService.updateRole(vo);
        return result;
    }

    @DeleteMapping("/role/{id}")
    @ApiOperation(value = "删除角色接口")
    @MyLog(title = "组织管理-角色管理", action = "删除角色接口")
    @RequiresPermissions("sys:role:delete")
    public DataResult deleteRole(@PathVariable("id") String id) {
        DataResult result = DataResult.success();
        roleService.deletedRole(id);
        return result;

    }
}
