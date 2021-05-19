package com.linjr.vo.req;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

public class RegionAddReqVO {

    @ApiModelProperty(value = "所属区域")
    @NotBlank(message = "所属区域不能为空")
    private String pid;

    @ApiModelProperty(value = "区域名称")
    @NotBlank(message = "区域名称不能为空")
    private String regionname;

    @ApiModelProperty(value = "区域负责人")
    @NotBlank(message = "区域负责人不能为空")
    private String manager;

    @ApiModelProperty(value = "手机号")
    @NotBlank(message = "手机号不能为空")
    private String phone;

    @ApiModelProperty(value = "身份证")
    @NotBlank(message = "身份证不能为空")
    private String identification;

    @ApiModelProperty(value = "计划需求IPAD数量")
    private Integer planipadsum;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public Integer getPlanipadsum() {
        return planipadsum;
    }

    public void setPlanipadsum(Integer planipadsum) {
        this.planipadsum = planipadsum;
    }

    public String getRegionname() {
        return regionname;
    }

    public void setRegionname(String regionname) {
        this.regionname = regionname;
    }

    @Override
    public String toString() {
        return "RegionAddReqVO{" +
                "pid='" + pid + '\'' +
                ", regionname='" + regionname + '\'' +
                ", manager='" + manager + '\'' +
                ", phone='" + phone + '\'' +
                ", identification='" + identification + '\'' +
                ", planipadsum=" + planipadsum +
                '}';
    }
}
