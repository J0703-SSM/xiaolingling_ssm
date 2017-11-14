package com.lanou.base.mapper;

import com.lanou.base.domain.RoleModule;

public interface RoleModuleMapper {
    int insert(RoleModule record);

    int insertSelective(RoleModule record);
}