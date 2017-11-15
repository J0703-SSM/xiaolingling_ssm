package com.lanou.role.dao;

import com.lanou.base.domain.RoleInfo;
import com.lanou.base.mapper.RoleInfoMapper;

import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public interface RoleInfoDao extends RoleInfoMapper {
    /**
     * 查询所有
     **/
    List<RoleInfo> selectAll();

    /**
     * 根据角色id查询角色对象
     **/
    RoleInfo selectRoleAndModuleById(int roleId);

    /**
     * 根据角色名查找角色对象
     *
     * @param roleName 角色名
     **/
    RoleInfo selectRoleByName(String roleName);

    /**
     * 取当前数据库的最大值对象
     **/
    Integer findMaxRoleId();
}
