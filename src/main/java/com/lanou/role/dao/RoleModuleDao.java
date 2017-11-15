package com.lanou.role.dao;

import com.lanou.base.domain.RoleModule;
import com.lanou.base.mapper.RoleModuleMapper;

import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public interface RoleModuleDao extends RoleModuleMapper {

    /**
     * 删除某个角色所对应的所有权限
     *
     * @param roleId 角色id
     **/
    int deleteByRoleId(Integer roleId);

    /**
     * 批量插入角色-权限对象
     *
     * @param roleModules 要插入的集合
     **/
    int addRoleModuleBatch(List<RoleModule> roleModules);

}
