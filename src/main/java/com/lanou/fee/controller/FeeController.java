package com.lanou.fee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Controller
@RequestMapping("/fee")
public class FeeController {

    @RequestMapping("/fee_add")
    public String feeAdd() {
        return "fee/fee_add";
    }

    @RequestMapping("/fee_detail")
    public String feeDetail() {
        return "fee/fee_detail";
    }

    @RequestMapping("/fee_list")
    public String feeList() {
        return "fee/fee_list";
    }

    @RequestMapping("/fee_modi")
    public String feeModi() {
        return "fee/fee_modi";
    }
}
