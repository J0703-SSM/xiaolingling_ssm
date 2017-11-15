package com.lanou.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Controller
public class BaseController {

    @RequestMapping({"/index","/"})
    public String index() {
        return "index";
    }

    @RequestMapping({"/login"})
    public String login() {
        return "login";
    }

    @RequestMapping("/error")
    public String error() {
        return "error";
    }

    @RequestMapping("/nopower")
    public String nopower() {
        return "nopower";
    }

}
