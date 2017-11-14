package com.lanou.bill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Controller
@RequestMapping("/bill")
public class BillController {

    @RequestMapping("/bill_item")
    public String billItem() {
        return "bill/bill_item";
    }

    @RequestMapping("/bill_list")
    public String billList() {
        return "bill/bill_list";
    }

    @RequestMapping("/bill_service_detail")
    public String billServiceDetail() {
        return "bill/bill_service_detail";
    }

}
