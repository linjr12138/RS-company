package com.linjr.service.Impl;

import com.linjr.entity.db1.SysUser;
import com.linjr.mapper.db1.SysUserMapper;
import com.linjr.service.HomeService;
import com.linjr.service.PermissionService;
import com.linjr.vo.resp.HomeRespVO;
import com.linjr.vo.resp.PermissionRespNodeVO;
import com.linjr.vo.resp.UserInfoRespVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private PermissionService permissionService;

    @Override
    public HomeRespVO setHome(String uesrId) {
        HomeRespVO homeRespVO = new HomeRespVO();
        /**
         * mock 导航菜单数据后期直接从DB获取
         */
//        String home="[{\"children\":[{\"children\":[{\"children\":[{\"children\":[{\"children\":[],\"id\":\"6\",\"title\":\"五级类目5-6\",\"url\":\"string\"}],\"id\":\"5\",\"title\":\"四级类目4-5\",\"url\":\"string\"}],\"id\":\"4\",\"title\":\"三级类目3-4\",\"url\":\"string\"}],\"id\":\"3\",\"title\":\"二级类目2-3\",\"url\":\"string\"}],\"id\":\"1\",\"title\":\"类目1\",\"url\":\"string\"},{\"children\":[],\"id\":\"2\",\"title\":\"类目2\",\"url\":\"string\"}]";
//        String home="[\n" +
//                "    {\n" +
//                "        \"children\": [\n" +
//                "            {\n" +
//                "                \"children\": [],\n" +
//                "                \"id\": \"3\",\n" +
//                "                \"title\": \"菜单权限管理\",\n" +
//                "                \"url\": \"/index/menus\"\n" +
//                "            }\n" +
//                "    {\n" +
//                "                \"children\": [],\n" +
//                "                \"id\": \"3\",\n" +
//                "                \"title\": \"角色权限管理\",\n" +
//                "                \"url\": \"/index/roles\"\n" +
//                "            }\n" +
//                "        ],\n" +
//                "        \"id\": \"1\",\n" +
//                "        \"title\": \"组织管理\",\n" +
//                "        \"url\": \"string\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"children\": [],\n" +
//                "        \"id\": \"2\",\n" +
//                "        \"title\": \"类目2\",\n" +
//                "        \"url\": \"/index/roles\"\n" +
//                "    }\n" +
//                "]";
        List<PermissionRespNodeVO> list = permissionService.permissionTreeList(uesrId);
//        List<PermissionRespNodeVO> list= JSON.parseArray(home,PermissionRespNodeVO.class);
        homeRespVO.setMenus(list);
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(uesrId);
        UserInfoRespVO vo = new UserInfoRespVO();
        if (sysUser != null) {
            BeanUtils.copyProperties(sysUser, vo);
            vo.setDeptName("林景荣有限公司");

        }
        homeRespVO.setUserInfoVO(vo);
        return homeRespVO;
    }
}
