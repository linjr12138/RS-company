package com.linjr.indexcontroller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
@Api(tags = "视图", description = "跳转视图的控制器")
public class IndexController {

    @GetMapping("/404")
    @ApiOperation(value = "跳转404错误的页面")
    public String error404() {
        return "error/404";
    }


    @GetMapping("/login")
    @ApiOperation(value = "跳转登陆页面")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    @ApiOperation(value = "跳转首页页面")
    public String home() {
        return "home";
    }

    @GetMapping("/main")
    @ApiOperation(value = "跳转主页页面")
    public String main() {
        return "main";
    }

    @GetMapping("/menus")
    @ApiOperation(value = "跳转菜单权限管理页面")
    public String menus() {
        return "menus/menu";
    }

    @GetMapping("/roles")
    @ApiOperation(value = "跳转角色管理页面")
    public String roles() {
        return "roles/role";
    }

    @GetMapping("/depts")
    @ApiOperation(value = "跳转部门管理页面")
    public String deptList() {
        return "depts/dept";
    }

    @GetMapping("/users")
    @ApiOperation(value = "跳转用户管理页面")
    public String userList() {
        return "users/user";
    }

    @GetMapping("/logs")
    @ApiOperation(value = "跳转日志管理页面")
    public String logList() {
        return "logs/log";
    }

    @GetMapping("/users/info")
    @ApiOperation(value = "跳转个人编辑页面")
    public String usersInfo() {
        return "users/user_edit";
    }

    @GetMapping("/users/pwd")
    @ApiOperation(value = "跳转更改密码页面")
    public String updatePwd() {
        return "users/user_pwd";
    }

    @GetMapping("/ipad")
    @ApiOperation(value = "跳转ipad管理页面")
    public String ipadInfo() {
        return "ipad/ipad";
    }

    @GetMapping("/regions")
    @ApiOperation(value = "跳转区域管理页面")
    public String regionInfo() {
        return "regions/region";
    }

    @GetMapping("/baseclients")
    @ApiOperation(value = "跳转客户资料管理页面")
    public String baseClientInfo() {
        return "clients/client";
    }

    @GetMapping("/products")
    @ApiOperation(value = "跳转客户资料管理页面")
    public String baseProductInfo() {
        return "products/product";
    }

    @GetMapping("/orders")
    @ApiOperation(value = "跳转订单管理页面")
    public String orderInfo() {
        return "orders/order";
    }

    @GetMapping("/testupload")
    @ApiOperation(value = "测试上传页面")
    public String testuploadInfo() {
        return "orders/testuploadFile";
    }

    @GetMapping("/OK")
    @ApiOperation(value = "测试上传页面")
    public String OKindex() {
        return "OK";
    }
}
