package com.lanou.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Controller
@RequestMapping("/service")
public class ServiceController {

    @RequestMapping("/service_add")
    public String serviceAdd() {
        return "service/service_add";
    }

    @RequestMapping("/service_detail")
    public String serviceDetail() {
        return "service/service_detail";
    }

    @RequestMapping("/service_list")
    public String serviceList() {
        return "service/service_list";
    }

    @RequestMapping("/service_modi")
    public String serviceModi() {
        return "service/service_modi";
    }
}
