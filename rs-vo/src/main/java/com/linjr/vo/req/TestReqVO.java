package com.linjr.vo.req;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @ClassName: TestReqVO
 * TODO:类文件简单描述
 * @Author: 小霍
 * @UpdateUser: 小霍
 * @Version: 0.0.1
 */

public class TestReqVO {
    @NotEmpty(message = "list 数据不能为空")
    @ApiModelProperty(value = "list 集合数据")
    private List<String> list;

    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名")
    private String username;

    @NotNull(message = "年龄不能为空")
    @ApiModelProperty(value = "年龄")
    private Integer age;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestReqVO{" +
                "list=" + list +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
