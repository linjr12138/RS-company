package com.linjr.filter;

import com.linjr.myfeign.UserByFeign;
import com.linjr.entity.db1.SysUser;
import com.linjr.utils.DataResult;
import com.linjr.vo.req.*;
import com.linjr.vo.resp.LoginRespVO;
import com.linjr.vo.resp.PageVO;
import com.linjr.vo.resp.UserOwnRoleRespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/webapi")
@Api(tags = "Feign用户接口")
public class UserApiService {

    @Autowired
    private UserByFeign userByFeign;

    @PostMapping("/login")
    public DataResult<LoginRespVO> login(@RequestBody LoginReqVO vo){
        return userByFeign.login(vo);
    }

    @GetMapping("/user/roles/{userId}")
    public DataResult<UserOwnRoleRespVO> getUserOwnRole(@PathVariable("userId") String userId){
        return userByFeign.getUserOwnRole(userId);
    }

    @PostMapping("/users")
    @RequiresPermissions("sys:user:list")
    public DataResult<PageVO<SysUser>> pageInfo(@RequestBody UserPageReqVO vo){
        return userByFeign.pageInfo(vo);
    }

    @PostMapping("/user")
    public DataResult addUser(@RequestBody @Valid UserAddReqVO vo){
        return userByFeign.addUser(vo);
    }

    @PutMapping("/user/roles")
    public DataResult saveUserRole(@RequestBody @Valid UserOwnRoleReqVO vo){
        return userByFeign.saveUserRole(vo);
    }

    @GetMapping("/user/token")
    public DataResult<String> refreshToken(@RequestHeader HttpServletRequest request){
        return userByFeign.refreshToken(request);
    }

    @PutMapping("/user")
    public DataResult updateUserInfo(@RequestBody @Valid UserUpdateReqVO vo, @RequestHeader HttpServletRequest request){
        return userByFeign.updateUserInfo(vo, request);
    }

    @DeleteMapping("/user")
    public DataResult deletedUsers(@RequestBody @ApiParam(value = "用户ID集合") List<String> list, @RequestHeader HttpServletRequest request){
        return userByFeign.deletedUsers(list, request);
    }

    @GetMapping("/user/logout")
    public DataResult logout(HttpServletRequest request){
        return userByFeign.logout(request);
    }

    @GetMapping("/user/info")
    public DataResult<SysUser> datailInfo(@RequestHeader HttpServletRequest request){
        return userByFeign.datailInfo(request);
    }

    @PutMapping("/user/info")
    public DataResult saveUserInfo(@RequestBody UserUpdateDetailInfoReqVO vo,@RequestHeader HttpServletRequest request){
        return userByFeign.saveUserInfo(vo, request);
    }

    @PutMapping("/user/pwd")
    public DataResult updatePwd(@RequestBody @Valid UserUpdatePwdReqVO vo,@RequestHeader HttpServletRequest request){
        return userByFeign.updatePwd(vo,request);
    }


}
