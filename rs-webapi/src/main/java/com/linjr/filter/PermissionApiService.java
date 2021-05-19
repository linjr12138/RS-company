package com.linjr.filter;

import com.linjr.aop.annotation.MyLog;
import com.linjr.entity.db1.SysPermission;
import com.linjr.myfeign.PerMissionByFeign;
import com.linjr.utils.DataResult;
import com.linjr.vo.req.PermissionAddReqVO;
import com.linjr.vo.req.PermissionUpdateReqVO;
import com.linjr.vo.resp.PermissionRespNodeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/webapi")
@Api(tags = "Feign用户接口")
public class PermissionApiService {


    @Autowired
    private PerMissionByFeign perMissionByFeign;

    @GetMapping("/permissions")
    @ApiOperation(value = "获取所有的菜单权限")
    @MyLog(title = "组织管理-菜单权限管理", action = "获取所有的菜单权限")
    @RequiresPermissions("sys:permission:list")
    public DataResult<List<SysPermission>> getAllPermission() {
       return perMissionByFeign.getAllPermission();
    }

    @GetMapping("/permission/tree")
    @ApiOperation(value = "菜单权限树接口-只递归查询到菜单")
    @MyLog(title = "组织管理-菜单权限管理", action = "菜单权限树接口-只递归查询到菜单")
    @RequiresPermissions(value = {"sys:permission:update", "sys:permission:add"}, logical = Logical.OR)
    public DataResult<List<PermissionRespNodeVO>> getAllPermissionTreeExBtn() {
        return perMissionByFeign.getAllPermissionTreeExBtn();
    }

    @PostMapping("/permission")
    @ApiOperation(value = "新增菜单权限")
    @MyLog(title = "组织管理-菜单权限管理", action = "新增菜单权限")
    @RequiresPermissions("sys:permission:add")
    public DataResult<SysPermission> addPermission(@RequestBody @Valid PermissionAddReqVO vo) {
        return perMissionByFeign.addPermission(vo);
    }

    @GetMapping("/permission/tree/all")
    @ApiOperation(value = "菜单权限树-递归查询所有")
    @MyLog(title = "组织管理-菜单权限管理", action = "菜单权限树-递归查询所有")
    @RequiresPermissions(value = {"sys:role:update", "sys:role:add"}, logical = Logical.OR)
    public DataResult<List<PermissionRespNodeVO>> getAllPermissionTree() {
       return perMissionByFeign.getAllPermissionTree();
    }

    @PutMapping("/permission")
    @ApiOperation(value = "编辑菜单权限接口")
    @MyLog(title = "组织管理-菜单权限管理", action = "编辑菜单权限接口")
    @RequiresPermissions("sys:permission:update")
    public DataResult updatePermission(@RequestBody @Valid PermissionUpdateReqVO vo) {
            return perMissionByFeign.updatePermission(vo);
    }

    @DeleteMapping("/permission/{permissionId}")
    @ApiOperation(value = "删除菜单权限接口")
    @MyLog(title = "组织管理-菜单权限管理", action = "删除菜单权限接口")
    @RequiresPermissions("sys:permission:delete")
    public DataResult deletedPermission(@PathVariable("permissionId") String permissionId) {
            return perMissionByFeign.deletedPermission(permissionId);
    }

}
