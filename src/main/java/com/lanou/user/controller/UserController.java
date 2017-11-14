package com.lanou.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/user_info")
    public String userInfo() {
        return "user/user_info";
    }

    @RequestMapping("/user_modi_pwd")
    public String userModiPwd() {
        return "user/user_modi_pwd";
    }
}
