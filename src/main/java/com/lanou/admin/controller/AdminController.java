package com.lanou.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/admin_add")
    public String adminAdd() {
        return "admin/admin_add";
    }


    @RequestMapping("/admin_list")
    public String adminList() {
        return "admin/admin_list";
    }


    @RequestMapping("/admin_modi")
    public String adminModi() {
        return "admin/admin_modi";
    }

}
