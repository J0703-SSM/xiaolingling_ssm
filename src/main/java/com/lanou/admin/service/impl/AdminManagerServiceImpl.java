package com.lanou.admin.service.impl;

import com.lanou.admin.dao.ModuleInfoDao;
import com.lanou.admin.service.AdminManagerService;
import com.lanou.base.domain.ModuleInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Service("adminManagerService")
public class AdminManagerServiceImpl implements AdminManagerService {
    @Resource
    private ModuleInfoDao moduleInfoDao;

    /**
     * 获得权限集合
     **/
    @Override
    public List<ModuleInfo> findAllModule() {
        return moduleInfoDao.findAllModule();
    }


    /**
     * 批量id查询
     **/
    @Override
    public List<ModuleInfo> findAllByIds(Integer[] ids) {
        return moduleInfoDao.findAllByIds(ids);
    }
}
