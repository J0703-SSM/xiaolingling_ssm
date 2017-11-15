package com.lanou.role.controller;

import com.lanou.admin.service.AdminManagerService;
import com.lanou.base.domain.ModuleInfo;
import com.lanou.base.domain.RoleInfo;
import com.lanou.base.domain.RoleModule;
import com.lanou.role.service.RoleMangerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Resource
    private RoleMangerService roleMangerService;
    @Resource
    private AdminManagerService adminManagerService;

    @RequestMapping("/role_add")
    public String roleAdd(Model model) {
        /*查询所有的权限集合*/
        List<ModuleInfo> moduleInfos = adminManagerService.findAllModule();
        model.addAttribute("moduleInfos", moduleInfos);
        return "role/role_add";
    }


    @RequestMapping("/role_list")
    public String roleList(Model model) {
        List<RoleInfo> roleInfos = roleMangerService.findAllRole();

        //将查询到的角色集合返回给页面
        model.addAttribute("roleInfos", roleInfos);

        return "role/role_list";
    }


    @RequestMapping("/role_modi")
    public String roleModi(Integer roleId, Model model) {
        RoleInfo roleInfo = roleMangerService.findRoleById(roleId);
        List<ModuleInfo> moduleInfos = adminManagerService.findAllModule();

//        System.out.println(roleId);
//        for (ModuleInfo info : moduleInfos) {
//            System.out.println("--->>" + roleInfo.getModuleInfos().contains(info));
//        }

        model.addAttribute("roleInfo", roleInfo);
        model.addAttribute("moduleInfos", moduleInfos);

        return "role/role_modi";
    }

    /**
     * 保存角色修改
     **/
    @ResponseBody
    @RequestMapping(value = "/roleModiSave", produces = "text/html; charset=utf-8")
    public String roleModiSave(@RequestParam(value = "moduleIds[]") Integer[] moduleIds,
                               Integer roleId) {
        //先找到要修改的权限对象
        System.out.println(moduleIds + " -- " + roleId);
        List<RoleModule> roleModules = roleMangerService.updateRoleModule(roleId, moduleIds);
        System.out.println(roleModules);

        return "success";
    }

    /**
     * 删除某个角色
     **/
    @ResponseBody
    @RequestMapping("/roleDelete")
    public String roleDelete(Integer roleId) {

        System.out.println(roleId);
        //删除角色
        int count = roleMangerService.deleteRoleById(roleId);

        System.out.println(count);

        return "success";
    }

    /**
     * 保存角色
     **/
    @ResponseBody
    @RequestMapping("/roleSave")
    public Integer roleSave(@RequestParam(value = "moduleIds[]") Integer[] moduleIds,
                            String roleName) {
        System.out.println(moduleIds);
        System.out.println(roleName);

        /*调用业务层的添加角色*/
        int count = roleMangerService.addRole(roleName, moduleIds);

        return count;
    }

}
