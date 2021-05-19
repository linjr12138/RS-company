package com.linjr.service;

import com.linjr.vo.req.UserOwnRoleReqVO;

import java.util.List;

public interface UserRoleService {

    List<String> getRoleIdByUserId(String userId);

    void addUserRoleInfo(UserOwnRoleReqVO vo);

    List<String> getUserIdByRoleIds(List<String> roles);

    List<String> getUserIdByRoleId(String roleId);

    int removeByRoleId(String roleId);
}
