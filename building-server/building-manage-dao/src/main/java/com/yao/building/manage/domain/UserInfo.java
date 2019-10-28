package com.yao.building.manage.domain;

import java.util.Date;

public class UserInfo {
    private Integer id;

    private String username;

    private String userMobile;

    private String userIdCard;

    private String idCardUrl1;

    private String idCardUrl2;

    private Integer status;

    private Date rentBeginTime;

    private Date rentEndTime;

    private Date createTime;

    private Date modifyTime;

    private String operator;

    private Integer version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    public String getUserIdCard() {
        return userIdCard;
    }

    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard == null ? null : userIdCard.trim();
    }

    public String getIdCardUrl1() {
        return idCardUrl1;
    }

    public void setIdCardUrl1(String idCardUrl1) {
        this.idCardUrl1 = idCardUrl1 == null ? null : idCardUrl1.trim();
    }

    public String getIdCardUrl2() {
        return idCardUrl2;
    }

    public void setIdCardUrl2(String idCardUrl2) {
        this.idCardUrl2 = idCardUrl2 == null ? null : idCardUrl2.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getRentBeginTime() {
        return rentBeginTime;
    }

    public void setRentBeginTime(Date rentBeginTime) {
        this.rentBeginTime = rentBeginTime;
    }

    public Date getRentEndTime() {
        return rentEndTime;
    }

    public void setRentEndTime(Date rentEndTime) {
        this.rentEndTime = rentEndTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}