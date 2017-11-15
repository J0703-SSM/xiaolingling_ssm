package com.lanou.role.service;

import com.lanou.base.domain.RoleInfo;
import com.lanou.base.domain.RoleModule;

import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public interface RoleMangerService {
    /**
     * 查询所有的角色
     **/
    List<RoleInfo> findAllRole();

    /**
     * 根据id查询某个角色
     *
     * @param roleId 角色id
     **/
    RoleInfo findRoleById(Integer roleId);

    /**
     * 根据角色id删除某个角色
     *
     * @param roleId 角色id
     **/
    int deleteRoleById(Integer roleId);

    /**
     * 根据角色id更新某个角色
     *
     * @param roleInfo 更新的角色对象
     **/
    int updateRoleById(RoleInfo roleInfo);

    /**
     * 添加某个角色
     *
     * @param roleInfo 要添加的角色
     **/
    int addRole(RoleInfo roleInfo);

    /**
     * 更新角色-权限对应关系
     *
     * @param roleId    要更新的角色id
     * @param moduleIds 要更新的权限集合id
     **/
    List<RoleModule> updateRoleModule(Integer roleId, Integer[] moduleIds);

    /**
     * 添加新的角色
     *
     * @param roleName  新的角色名
     * @param moduleIds 新角色的权限集合
     **/
    int addRole(String roleName, Integer[] moduleIds);
}
