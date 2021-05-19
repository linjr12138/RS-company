package com.linjr.myfeign;

import com.linjr.contants.ServiceName;
import com.linjr.entity.db1.SysUser;
import com.linjr.myhystrix.UserByHystrix;
import com.linjr.utils.DataResult;
import com.linjr.vo.req.*;
import com.linjr.vo.resp.LoginRespVO;
import com.linjr.vo.resp.PageVO;
import com.linjr.vo.resp.UserOwnRoleRespVO;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@FeignClient(name = ServiceName.RS_web,fallback = UserByHystrix.class)
public interface UserByFeign {

    @PostMapping("/api/user/login")
    DataResult<LoginRespVO> login(@RequestBody LoginReqVO vo);

    @PostMapping("/api/users")
    DataResult<PageVO<SysUser>> pageInfo(@RequestBody UserPageReqVO vo);

    @PostMapping("/api/user")
    DataResult addUser(@RequestBody @Valid UserAddReqVO vo);

    @GetMapping("/api/user/roles/{userId}")
    DataResult<UserOwnRoleRespVO> getUserOwnRole(@PathVariable("userId") String userId);

    @PutMapping("/api/user/roles")
    DataResult saveUserRole(@RequestBody @Valid UserOwnRoleReqVO vo);

    @GetMapping("/api/user/token")
    DataResult<String> refreshToken(@RequestHeader HttpServletRequest request);

    @PutMapping("/api/user")
    DataResult updateUserInfo(@RequestBody @Valid UserUpdateReqVO vo, @RequestHeader HttpServletRequest request);

    @DeleteMapping("/api/user")
    DataResult deletedUsers(@RequestBody @ApiParam(value = "用户ID集合") List<String> list,@RequestHeader HttpServletRequest request);

    @GetMapping("/api/user/logout")
    DataResult logout(HttpServletRequest request);

    @GetMapping("/api/user/info")
    DataResult<SysUser> datailInfo(@RequestHeader HttpServletRequest request);

    @PutMapping("/api/user/info")
    DataResult saveUserInfo(@RequestBody UserUpdateDetailInfoReqVO vo,@RequestHeader HttpServletRequest request);

    @PutMapping("/api/user/pwd")
    DataResult updatePwd(@RequestBody @Valid UserUpdatePwdReqVO vo,@RequestHeader HttpServletRequest request);



}
