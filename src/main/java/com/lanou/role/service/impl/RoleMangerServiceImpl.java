package com.lanou.role.service.impl;

import com.lanou.admin.dao.AdminRoleDao;
import com.lanou.base.domain.RoleInfo;
import com.lanou.base.domain.RoleModule;
import com.lanou.role.dao.RoleInfoDao;
import com.lanou.role.dao.RoleModuleDao;
import com.lanou.role.service.RoleMangerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Service("roleMangerService")
public class RoleMangerServiceImpl implements RoleMangerService {
    @Resource
    private RoleInfoDao roleInfoDao;

    @Resource
    private RoleModuleDao roleModuleDao;

    @Resource
    private AdminRoleDao adminRoleDao;

    /**
     * 查询所有的角色
     **/
    @Override
    public List<RoleInfo> findAllRole() {
        return roleInfoDao.selectAll();
    }

    /**
     * 根据id查询某个角色
     *
     * @param roleId 角色id
     **/
    @Override
    public RoleInfo findRoleById(Integer roleId) {
        return roleInfoDao.selectRoleAndModuleById(roleId);
    }

    /**
     * 根据角色id删除某个角色
     *
     * @param roleId 角色id
     **/
    @Override
    public int deleteRoleById(Integer roleId) {
        /*1、删除admin_role的相关记录
        * 2、删除role_module的相关记录
        * 3、删除role_info记录
        * */
        adminRoleDao.deleteByRoleId(roleId);

        roleModuleDao.deleteByRoleId(roleId);//删除角色-权限映射

        return roleInfoDao.deleteByPrimaryKey(roleId);
    }


    /**
     * 根据角色id更新某个角色
     *
     * @param roleInfo 更新的角色对象
     **/
    @Override
    public int updateRoleById(RoleInfo roleInfo) {
        return roleInfoDao.updateByPrimaryKeySelective(roleInfo);
    }

    /**
     * 添加某个角色
     *
     * @param roleInfo 要添加的角色
     **/
    @Override
    public int addRole(RoleInfo roleInfo) {
        return roleInfoDao.insertSelective(roleInfo);
    }

    /**
     * 更新角色-权限对应关系
     *
     * @param roleId    要更新的角色id
     * @param moduleIds 要更新的权限集合id
     **/
    @Override
    public List<RoleModule> updateRoleModule(Integer roleId, Integer[] moduleIds) {
        int delCount = roleModuleDao.deleteByRoleId(roleId);//先删除原来的对应关系
        System.out.println("删除的条数：" + delCount);

        /*更新角色所对应的权限集合*/
        List<RoleModule> roleModules = new ArrayList<>();

        for (Integer moduleId : moduleIds) {
            /*创建角色-权限对象*/
            RoleModule roleModule = new RoleModule(roleId, moduleId);

            /*加入集合*/
            roleModules.add(roleModule);
        }
        int addCount = roleModuleDao.addRoleModuleBatch(roleModules);//批量插入角色对应的权限
        System.out.println("插入的条数：" + addCount);

        return roleModules;
    }

    /**
     * 添加新的角色
     *
     * @param roleName  新的角色名
     * @param moduleIds 新角色的权限集合
     **/
    @Override
    public int addRole(String roleName, Integer[] moduleIds) {
        /*先查找新建的角色名是否已经存在在数据库表中*/
        RoleInfo roleInfo = roleInfoDao.selectRoleByName(roleName);
        if (roleInfo != null) {
            return 0;
        }
        /*角色id 在原来最大值的基础上加100*/
        int roleId = roleInfoDao.findMaxRoleId() + 100;

        RoleInfo role = new RoleInfo(roleId, roleName);
        int roleCount = roleInfoDao.insertSelective(role);//插入新角色
        System.out.println(roleCount);

        /*如果有要加入的权限列表*/
        if (moduleIds != null && moduleIds.length > 0) {
            List<RoleModule> roleModuleList = new ArrayList<>();
            for (int i = 0; i < moduleIds.length; i++) {
                RoleModule roleModule = new RoleModule(roleId, moduleIds[i]);
                roleModuleList.add(roleModule);
            }

            int rmCount = roleModuleDao.addRoleModuleBatch(roleModuleList);//批量加入角色-权限表

            System.out.println(rmCount);
        }

        return roleCount;
    }

}
