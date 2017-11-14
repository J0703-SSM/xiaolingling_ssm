package com.lanou.test;

import com.lanou.account.dao.AccountDao;
import com.lanou.base.mapper.AccountMapper;
import com.lanou.base.mapper.AdminInfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-*.xml")
public class DaoTest {

    @Autowired
    private AccountDao accountDao;
    @Resource
    private AccountMapper accountMapper;
    @Resource
    private AdminInfoMapper adminInfoMapper;


    @Test
    public void testMapper() {
        System.out.println(accountDao.getClass().getSimpleName());

        System.out.println(accountMapper.getClass().getSimpleName());

        System.out.println(adminInfoMapper.getClass().getSimpleName());

//        List<Account> accounts = accountDao.selectAll();
//        for (Account account : accounts) {
//            System.out.println(account.getLoginName());
//        }

    }
}
