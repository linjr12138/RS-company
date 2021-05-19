package com.linjr.myhystrix;

import com.linjr.entity.db1.SysUser;
import com.linjr.exception.BusinessException;
import com.linjr.exception.code.BaseResponseCode;
import com.linjr.myfeign.UserByFeign;
import com.linjr.utils.DataResult;
import com.linjr.vo.req.*;
import com.linjr.vo.resp.LoginRespVO;
import com.linjr.vo.resp.PageVO;
import com.linjr.vo.resp.UserOwnRoleRespVO;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

public class UserByHystrix implements UserByFeign {
    @Override
    public DataResult<LoginRespVO> login(LoginReqVO vo) {
        throw new BusinessException(BaseResponseCode.SYSTEM_ERROR);
    }

    @Override
    public DataResult<PageVO<SysUser>> pageInfo(UserPageReqVO vo) {
        throw new BusinessException(BaseResponseCode.SYSTEM_ERROR);
    }

    @Override
    public DataResult addUser(@Valid UserAddReqVO vo) {
        throw new BusinessException(BaseResponseCode.SYSTEM_ERROR);
    }

    @Override
    public DataResult<UserOwnRoleRespVO> getUserOwnRole(String userId) {
        throw new BusinessException(BaseResponseCode.SYSTEM_ERROR);
    }

    @Override
    public DataResult saveUserRole(@Valid UserOwnRoleReqVO vo) {
        throw new BusinessException(BaseResponseCode.SYSTEM_ERROR);
    }

    @Override
    public DataResult<String> refreshToken(HttpServletRequest request) {
        throw new BusinessException(BaseResponseCode.SYSTEM_ERROR);
    }

    @Override
    public DataResult updateUserInfo(@Valid UserUpdateReqVO vo, HttpServletRequest request) {
        throw new BusinessException(BaseResponseCode.SYSTEM_ERROR);
    }

    @Override
    public DataResult deletedUsers(List<String> list, HttpServletRequest request) {
        throw new BusinessException(BaseResponseCode.SYSTEM_ERROR);
    }

    @Override
    public DataResult logout(HttpServletRequest request) {
        throw new BusinessException(BaseResponseCode.SYSTEM_ERROR);
    }

    @Override
    public DataResult<SysUser> datailInfo(HttpServletRequest request) {
        throw new BusinessException(BaseResponseCode.SYSTEM_ERROR);
    }

    @Override
    public DataResult saveUserInfo(UserUpdateDetailInfoReqVO vo, HttpServletRequest request) {
        throw new BusinessException(BaseResponseCode.SYSTEM_ERROR);
    }

    @Override
    public DataResult updatePwd(@Valid UserUpdatePwdReqVO vo, HttpServletRequest request) {
        throw new BusinessException(BaseResponseCode.SYSTEM_ERROR);
    }
}
