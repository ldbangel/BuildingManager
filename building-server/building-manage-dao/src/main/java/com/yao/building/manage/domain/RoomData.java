package com.yao.building.manage.domain;

import java.util.Date;

public class RoomData {
    private Integer id;

    private Integer roomId;

    private Integer rent;

    private Integer energyNum;

    private Integer energyUseCount;

    private Integer waterNum;

    private Integer waterUseCount;

    private Integer openInternet;

    private Integer rentStatus;

    private Date readTime;

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

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getRent() {
        return rent;
    }

    public void setRent(Integer rent) {
        this.rent = rent;
    }

    public Integer getEnergyNum() {
        return energyNum;
    }

    public void setEnergyNum(Integer energyNum) {
        this.energyNum = energyNum;
    }

    public Integer getEnergyUseCount() {
        return energyUseCount;
    }

    public void setEnergyUseCount(Integer energyUseCount) {
        this.energyUseCount = energyUseCount;
    }

    public Integer getWaterNum() {
        return waterNum;
    }

    public void setWaterNum(Integer waterNum) {
        this.waterNum = waterNum;
    }

    public Integer getWaterUseCount() {
        return waterUseCount;
    }

    public void setWaterUseCount(Integer waterUseCount) {
        this.waterUseCount = waterUseCount;
    }

    public Integer getOpenInternet() {
        return openInternet;
    }

    public void setOpenInternet(Integer openInternet) {
        this.openInternet = openInternet;
    }

    public Integer getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(Integer rentStatus) {
        this.rentStatus = rentStatus;
    }

    public Date getReadTime() {
        return readTime;
    }

    public void setReadTime(Date readTime) {
        this.readTime = readTime;
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