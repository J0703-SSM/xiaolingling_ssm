package com.lanou.admin.dao;

import com.lanou.base.mapper.AdminRoleMapper;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public interface AdminRoleDao extends AdminRoleMapper {

    /**
     * 根据角色ID删除用户-角色映射关系
     *
     * @param roleId 角色id
     **/
    int deleteByRoleId(Integer roleId);
}
