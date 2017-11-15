package com.lanou.base.domain;

public class ModuleInfo {
    private Integer moduleId;

    private String name;

    public ModuleInfo(Integer moduleId, String name) {
        this.moduleId = moduleId;
        this.name = name;
    }

    public ModuleInfo() {
        super();
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Override
    public String toString() {
        return "ModuleInfo{" +
                "moduleId=" + moduleId +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModuleInfo that = (ModuleInfo) o;

        if (!moduleId.equals(that.moduleId)) return false;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = moduleId.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}