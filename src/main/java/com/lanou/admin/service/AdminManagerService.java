package com.lanou.admin.service;

import com.lanou.base.domain.ModuleInfo;

import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public interface AdminManagerService {

    /**
     * 获得权限集合
     **/
    List<ModuleInfo> findAllModule();


    /**
     * 批量id查询
     **/
    List<ModuleInfo> findAllByIds(Integer[] ids);

}
