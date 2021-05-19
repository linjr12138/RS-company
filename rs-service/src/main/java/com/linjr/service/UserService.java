package com.linjr.service;


import com.linjr.entity.db1.SysUser;
import com.linjr.vo.req.*;
import com.linjr.vo.resp.LoginRespVO;
import com.linjr.vo.resp.PageVO;
import com.linjr.vonew.UserOwnRoleRespVO;

import java.util.List;

public interface UserService {

    LoginRespVO login(LoginReqVO vo);

    PageVO<SysUser> pageInfo(UserPageReqVO vo);

    void addUser(UserAddReqVO vo);

    UserOwnRoleRespVO getUserOwnRole(String userId);

    void setUserOwnRole(UserOwnRoleReqVO vo);

    String refreshToken(String refreshToken);

    void updateUserInfo(UserUpdateReqVO vo, String operationId);

    void deletedUsers(List<String> list, String operation);

    List<SysUser> selectUserInfoByDeptIds(List<String> deptIds);

    void logout(String accessToken, String refreshToken);

    SysUser datailInfo(String userId);

    //个人用户编辑信息接口
    void userUpdateDetailInfo(UserUpdateDetailInfoReqVO vo, String userId);

    void userUpdatePwd(UserUpdatePwdReqVO vo, String accessToken, String refreshToken);

}
