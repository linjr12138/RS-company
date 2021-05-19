package com.linjr.vo.resp;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @ClassName: HomeRespVO
 * TODO:类文件简单描述
 * @Author: 小霍
 * @UpdateUser: 小霍
 * @Version: 0.0.1
 */

public class HomeRespVO {
    @ApiModelProperty(value = "用户信息")
    private UserInfoRespVO userInfoVO;

    @ApiModelProperty(value = "首页菜单导航数据")
    private List<PermissionRespNodeVO> menus;

    public UserInfoRespVO getUserInfoVO() {
        return userInfoVO;
    }

    public void setUserInfoVO(UserInfoRespVO userInfoVO) {
        this.userInfoVO = userInfoVO;
    }

    public List<PermissionRespNodeVO> getMenus() {
        return menus;
    }

    public void setMenus(List<PermissionRespNodeVO> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "HomeRespVO{" +
                "userInfoVO=" + userInfoVO +
                ", menus=" + menus +
                '}';
    }
}
