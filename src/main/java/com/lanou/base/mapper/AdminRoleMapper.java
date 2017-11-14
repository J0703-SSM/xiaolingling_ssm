package com.lanou.base.mapper;

import com.lanou.base.domain.AdminRole;

public interface AdminRoleMapper {
    int insert(AdminRole record);

    int insertSelective(AdminRole record);
}