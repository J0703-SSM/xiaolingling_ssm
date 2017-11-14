package com.lanou.account.controller;

import com.lanou.base.domain.Account;
import com.lanou.base.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @RequestMapping("/account_add")
    public String accountAdd() {
        return "account/account_add";
    }

    @RequestMapping("/account_detail")
    public String accountDetail() {
        return "account/account_detail";
    }


    @RequestMapping("/account_list")
    public String accountList() {
        return "account/account_list";
    }

    @RequestMapping("/account_modi")
    public String accountModi() {
        return "account/account_modi";
    }


    @ResponseBody
    @RequestMapping(value = "/account_save")
    public Result<Account> accountSave(String loginName) {

        Account account = new Account();
        account.setLoginName(loginName);

        if ("".equals(loginName)) {
            return new Result<>(false, "用户名不能为空");
        }
        System.out.println(loginName);


        return new Result<>(true, account);
    }

    @ResponseBody
    @RequestMapping(value = "/accountCommit", produces = "text/html; charset=utf-8")
    public String accountCommit(@RequestParam(value = "loginName[]", required = false) String[] loginName) {
        System.out.println(loginName);
        return "成功";
    }

    @ResponseBody
    @RequestMapping("/accountform")
    public void accountform(String username) {

        System.out.println(username);
    }
}
