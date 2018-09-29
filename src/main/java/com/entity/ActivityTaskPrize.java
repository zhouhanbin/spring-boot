package com.entity;

import java.util.Date;

public class ActivityTaskPrize {
    private Integer id;

    private Integer activityTaskId;

    private String name;

    private String icon;

    private Integer prizeId;

    private Integer days;

    private String des;

    private Integer status;

    private Date createTime;

    private String createUser;

    private Date updateTime;

    private String updateUser;

    private Integer type;

    private String acceptPrizeDes;

    private String virtualPrizeUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivityTaskId() {
        return activityTaskId;
    }

    public void setActivityTaskId(Integer activityTaskId) {
        this.activityTaskId = activityTaskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Integer getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Integer prizeId) {
        this.prizeId = prizeId;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAcceptPrizeDes() {
        return acceptPrizeDes;
    }

    public void setAcceptPrizeDes(String acceptPrizeDes) {
        this.acceptPrizeDes = acceptPrizeDes == null ? null : acceptPrizeDes.trim();
    }

    public String getVirtualPrizeUrl() {
        return virtualPrizeUrl;
    }

    public void setVirtualPrizeUrl(String virtualPrizeUrl) {
        this.virtualPrizeUrl = virtualPrizeUrl == null ? null : virtualPrizeUrl.trim();
    }
}