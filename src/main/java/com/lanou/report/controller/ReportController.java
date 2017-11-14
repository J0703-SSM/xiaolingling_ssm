package com.lanou.report.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Controller
@RequestMapping("/report")
public class ReportController {

    @RequestMapping("/report_list")
    public String reportList() {
        return "report/report_list";
    }
}
