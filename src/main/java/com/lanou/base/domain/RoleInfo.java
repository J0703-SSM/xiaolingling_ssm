package com.lanou.base.domain;

import java.util.List;

public class RoleInfo {
    private Integer roleId;

    private String name;
    /**
     * 该角色对应的权限集合
     **/
    private List<ModuleInfo> moduleInfos;

    public RoleInfo(Integer roleId, String name) {
        this.roleId = roleId;
        this.name = name;
    }

    public RoleInfo() {
        super();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public List<ModuleInfo> getModuleInfos() {
        return moduleInfos;
    }

    public void setModuleInfos(List<ModuleInfo> moduleInfos) {
        this.moduleInfos = moduleInfos;
    }

    @Override
    public String toString() {
        return "RoleInfo{" +
                "roleId=" + roleId +
                ", name='" + name + '\'' +
                '}';
    }
}