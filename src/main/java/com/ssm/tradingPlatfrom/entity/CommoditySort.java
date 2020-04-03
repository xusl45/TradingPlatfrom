package com.ssm.tradingPlatfrom.entity;

public class CommoditySort {

    private int id;
    private String sortName;
    private String iconPath;
    private String isDelete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "CommoditySort{" +
                "id=" + id +
                ", sortName='" + sortName + '\'' +
                ", iconPath='" + iconPath + '\'' +
                ", isDelete='" + isDelete + '\'' +
                '}';
    }
}
