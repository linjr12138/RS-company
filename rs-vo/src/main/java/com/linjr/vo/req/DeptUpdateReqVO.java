package com.linjr.vo.req;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName: DeptUpdateReqVO
 * TODO:类文件简单描述
 * @Author: 小霍
 * @UpdateUser: 小霍
 * @Version: 0.0.1
 */

public class DeptUpdateReqVO {
    @ApiModelProperty(value = "部门id")
    @NotBlank(message = "部门id不能为空")
    private String id;
    @ApiModelProperty(value = "部门呢名称")
    private String name;
    @ApiModelProperty(value = "父级id")
    private String pid;
    @ApiModelProperty(value = "部门状态(1:正常；0:弃用)")
    private Integer status;
    @ApiModelProperty(value = "部门经理名称")
    private String managerName;
    @ApiModelProperty(value = "部门经理电话")
    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "DeptUpdateReqVO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pid='" + pid + '\'' +
                ", status=" + status +
                ", managerName='" + managerName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
