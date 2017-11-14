package com.lanou.role.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @RequestMapping("/role_add")
    public String roleAdd() {
        return "role/role_add";
    }


    @RequestMapping("/role_list")
    public String roleList() {
        return "role/role_list";
    }


    @RequestMapping("/role_modi")
    public String roleModi() {
        return "role/role_modi";
    }

}
