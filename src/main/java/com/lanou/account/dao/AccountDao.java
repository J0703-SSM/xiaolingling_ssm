package com.lanou.account.dao;

import com.lanou.base.domain.Account;
import com.lanou.base.mapper.AccountMapper;

import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public interface AccountDao extends AccountMapper {

    List<Account> selectAll();
}
