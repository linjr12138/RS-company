package com.linjr.controller;


import com.linjr.aop.annotation.MyLog;
import com.linjr.contants.Constant;
import com.linjr.entity.db1.SysUser;
import com.linjr.service.UserService;
import com.linjr.utils.DataResult;
import com.linjr.utils.JwtTokenUtil;
import com.linjr.vo.req.*;
import com.linjr.vo.resp.LoginRespVO;
import com.linjr.vo.resp.PageVO;
import com.linjr.vo.resp.UserOwnRoleRespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api(tags = "用户模块相关接口")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户登陆接口")
    @PostMapping("/user/login")
    @MyLog(title = "组织管理-用户模块相关接口", action = "用户登陆接口")
    public DataResult<LoginRespVO> login(@RequestBody LoginReqVO vo) {
        DataResult result = DataResult.success();
        result.setData(userService.login(vo));
        return result;
    }

    @ApiOperation(value = "分页用户接口")
    @PostMapping("/users")
    @MyLog(title = "组织管理-用户模块相关接口", action = "分页用户接口")
    @RequiresPermissions("sys:user:list")
    public DataResult<PageVO<SysUser>> pageInfo(@RequestBody UserPageReqVO vo) {
        DataResult result = DataResult.success();
        result.setData(userService.pageInfo(vo));
        return result;
    }

    @ApiOperation(value = "新增用户接口")
    @PostMapping("/user")
    @MyLog(title = "组织管理-用户模块相关接口", action = "新增用户接口")
    @RequiresPermissions("sys:user:add")
    public DataResult addUser(@RequestBody @Valid UserAddReqVO vo) {
        DataResult result = DataResult.success();
        userService.addUser(vo);
        return result;
    }

    @ApiOperation(value = "查询用户拥有的角色数据接口")
    @GetMapping("/user/roles/{userId}")
    @MyLog(title = "组织管理-用户模块相关接口", action = "查询用户拥有的角色数据接口")
    @RequiresPermissions("sys:user:role:update")
    public DataResult<UserOwnRoleRespVO> getUserOwnRole(@PathVariable("userId") String userId) {
        DataResult result = DataResult.success();
        result.setData(userService.getUserOwnRole(userId));
        return result;
    }

    @PutMapping("/user/roles")
    @ApiOperation(value = "保存用户拥有的角色信息接口")
    @MyLog(title = "组织管理-用户模块相关接口", action = "保存用户拥有的角色信息接口")
    public DataResult saveUserRole(@RequestBody @Valid UserOwnRoleReqVO vo) {
        DataResult result = DataResult.success();
        userService.setUserOwnRole(vo);
        return result;
    }

    @GetMapping("/user/token")
    @ApiOperation(value = "刷新Token接口")
    @MyLog(title = "组织管理-用户模块相关接口", action = "刷新Token接口")
    public DataResult<String> refreshToken(HttpServletRequest request) {
        String refreshToken = request.getHeader(Constant.REFRESH_TOKEN);
        String s = userService.refreshToken(refreshToken);
        DataResult result = DataResult.success();
        result.setData(s);
        return result;
    }

    @PutMapping("/user")
    @ApiOperation(value = "列表修改用户信息接口")
    @MyLog(title = "组织管理-用户模块相关接口", action = "列表修改用户信息接口")
    @RequiresPermissions("sys:user:update")
    public DataResult updateUserInfo(@RequestBody @Valid UserUpdateReqVO vo, HttpServletRequest request) {
        String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
        String userId = JwtTokenUtil.getUserId(accessToken);
        DataResult result = DataResult.success();
        userService.updateUserInfo(vo, userId);
        return result;
    }

    @DeleteMapping("/user")
    @ApiOperation(value = "删除/批量删除用户接口")
    @MyLog(title = "组织管理-用户模块相关接口", action = "删除/批量删除用户接口")
    @RequiresPermissions("sys:user:delete")
    public DataResult deletedUsers(@RequestBody @ApiParam(value = "用户ID集合") List<String> list, HttpServletRequest request) {
        String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
        String operationId = JwtTokenUtil.getUserId(accessToken);
        userService.deletedUsers(list, operationId);
        DataResult result = DataResult.success();
        return result;
    }

    @GetMapping("/user/logout")
    @ApiOperation(value = "用户退出登陆")
    @MyLog(title = "组织管理-用户模块相关接口", action = "用户退出登陆")
    public DataResult logout(HttpServletRequest request) {
        try {
            String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
            String refreshToken = request.getHeader(Constant.REFRESH_TOKEN);
            userService.logout(accessToken, refreshToken);
        } catch (Exception e) {
            log.error("logout:{}", e);
        }
        return DataResult.success();

    }

    @GetMapping("/user/info")
    @ApiOperation(value = "获取用户信息详情接口")
    @MyLog(title = "组织管理-用户模块相关接口", action = "获取用户信息详情接口")
    public DataResult<SysUser> datailInfo(HttpServletRequest request) {
        String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
        String id = JwtTokenUtil.getUserId(accessToken);
        DataResult result = DataResult.success();
        result.setData(userService.datailInfo(id));
        return result;
    }

    @PutMapping("/user/info")
    @ApiOperation(value = "保存个人信息接口")
    @MyLog(title = "组织管理-用户模块相关接口", action = "保存个人信息接口")
    public DataResult saveUserInfo(@RequestBody UserUpdateDetailInfoReqVO vo, HttpServletRequest request) {
        String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
        String userId = JwtTokenUtil.getUserId(accessToken);
        DataResult result = DataResult.success();
        userService.userUpdateDetailInfo(vo, userId);
        return result;
    }

    @PutMapping("/user/pwd")
    @ApiOperation(value = "修改个人密码接口")
    @MyLog(title = "组织管理-用户模块相关接口", action = "修改个人密码接口")
    public DataResult updatePwd(@RequestBody @Valid UserUpdatePwdReqVO vo, HttpServletRequest request) {
        String accessToken = request.getHeader(Constant.ACCESS_TOKEN);
        String refreshToken = request.getHeader(Constant.REFRESH_TOKEN);
        DataResult result = DataResult.success();
        userService.userUpdatePwd(vo, accessToken, refreshToken);
        return result;
    }
}
