package com.lanou.test;

import com.lanou.account.dao.AccountDao;
import com.lanou.admin.dao.ModuleInfoDao;
import com.lanou.base.domain.ModuleInfo;
import com.lanou.base.mapper.AccountMapper;
import com.lanou.base.mapper.AdminInfoMapper;
import com.lanou.role.dao.RoleInfoDao;
import com.lanou.role.dao.RoleModuleDao;
import com.lanou.role.service.RoleMangerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private RoleInfoDao roleInfoDao;

    @Resource
    private ModuleInfoDao moduleInfoDao;

    @Resource
    private RoleModuleDao roleModuleDao;

    @Resource
    private RoleMangerService roleMangerService;

    @Test
    public void testRole() {
        /*查询所有*/
//        List<RoleInfo> roleInfos = roleInfoDao.selectAll();
//        for (RoleInfo info : roleInfos) {
//            System.out.println(info);
//            for (ModuleInfo moduleInfo : info.getModuleInfos()) {
//                System.out.println(moduleInfo);
//            }
//        }

        /*查询单个*/
//        RoleInfo roleInfo = roleInfoDao.selectRoleAndModuleById(100);
//        System.out.println(roleInfo);
//        for (ModuleInfo moduleInfo : roleInfo.getModuleInfos()) {
//            System.out.println(moduleInfo);
//        }

//        int count = roleMangerService.deleteRoleById(600);
        Integer[] moduleIds = {1, 2};

        int count = roleMangerService.addRole("cc", moduleIds);

        System.out.println(count);


//        int maxRoleId = roleInfoDao.findMaxRoleId();
//        System.out.println(maxRoleId);

    }


    @Test
    public void testModule() {
        Integer[] ids = {1, 2, 3};
        List<ModuleInfo> moduleInfos = moduleInfoDao.findAllByIds(ids);
        for (ModuleInfo moduleInfo : moduleInfos) {
            System.out.println(moduleInfo);
        }
    }


    @Test
    public void testRoleModule() {
//        List<RoleModule> roleModules = new ArrayList<>();
//        roleModules.add(new RoleModule(600,7));
//        int count = roleModuleDao.addRoleModuleBatch(roleModules);
//

        int count = roleModuleDao.deleteByRoleId(600);
        System.out.println(count);
    }

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
