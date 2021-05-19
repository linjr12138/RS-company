package com.linjr.controller;

import com.linjr.aop.annotation.MyLog;
import com.linjr.entity.db1.SysDept;
import com.linjr.service.DeptService;
import com.linjr.utils.DataResult;
import com.linjr.vo.req.DeptAddReqVO;
import com.linjr.vo.req.DeptUpdateReqVO;
import com.linjr.vo.resp.DeptRespNodeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api(tags = "组织管理-部门管理", description = "部门管理相关接口")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    @ApiOperation(value = "查询所有部门数据")
    @MyLog(title = "组织管理-部门管理", action = "获取部门数据列表")
    @RequiresPermissions("sys:dept:list")
    public DataResult<List<SysDept>> getAllDept() {
        DataResult result = DataResult.success();
        result.setData(deptService.selectAll());
        return result;
    }

    @GetMapping("/dept/tree")
    @ApiOperation(value = "查询所有部门树数据")
    @MyLog(title = "组织管理-部门管理", action = "获取部门树")
    @RequiresPermissions(value = {"sys:user:update", "sys:user:add", "sys:dept:add", "sys:dept:update"}, logical = Logical.OR)
    public DataResult<List<DeptRespNodeVO>> getDeptTree(@RequestParam(required = false) String deptId) {
        DataResult result = DataResult.success();
        result.setData(deptService.deptTreeList(deptId));
        return result;
    }

    @PostMapping("/dept")
    @ApiOperation(value = "新增部门数据接口")
    @MyLog(title = "组织管理-部门管理", action = "新增部门数据列表")
    @RequiresPermissions("sys:dept:add")
    public DataResult<SysDept> addDept(@RequestBody @Valid DeptAddReqVO vo) {
        DataResult result = DataResult.success();
        result.setData(deptService.addDept(vo));
        return result;
    }

    @PutMapping("/dept")
    @ApiOperation(value = "跟新部门数据接口")
    @MyLog(title = "组织管理-部门管理", action = "跟新部门数据列表")
    @RequiresPermissions("sys:dept:update")
    public DataResult updateDept(@RequestBody @Valid DeptUpdateReqVO vo) {
        deptService.updateDept(vo);
        DataResult result = DataResult.success();
        return result;
    }

    @DeleteMapping("/dept/{id}")
    @ApiOperation(value = "删除部门接口")
    @MyLog(title = "组织管理-部门管理", action = "删除部门数据列表")
    @RequiresPermissions("sys:dept:delete")
    public DataResult deletedDepts(@PathVariable("id") String id) {
        deptService.deletedDept(id);
        DataResult result = DataResult.success();
        return result;
    }
}
