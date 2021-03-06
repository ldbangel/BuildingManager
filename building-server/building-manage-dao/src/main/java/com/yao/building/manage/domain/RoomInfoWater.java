package com.yao.building.manage.domain;

import java.math.BigDecimal;
import java.util.Date;

public class RoomInfoWater {
    private Integer id;

    private Integer index;

    private Integer roomNo;

    private String roomDesc;

    private Integer roomType;

    private String roomTypeDesc;

    private Integer rent;

    private Integer openInternet;

    private Integer energyNum;

    private Integer waterNum;

    private BigDecimal energyUnit;

    private BigDecimal waterUnit;

    private Integer roomStatus;

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

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomDesc() {
        return roomDesc;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc == null ? null : roomDesc.trim();
    }

    public Integer getRoomType() {
        return roomType;
    }

    public void setRoomType(Integer roomType) {
        this.roomType = roomType;
    }

    public String getRoomTypeDesc() {
        return roomTypeDesc;
    }

    public void setRoomTypeDesc(String roomTypeDesc) {
        this.roomTypeDesc = roomTypeDesc == null ? null : roomTypeDesc.trim();
    }

    public Integer getRent() {
        return rent;
    }

    public void setRent(Integer rent) {
        this.rent = rent;
    }

    public Integer getOpenInternet() {
        return openInternet;
    }

    public void setOpenInternet(Integer openInternet) {
        this.openInternet = openInternet;
    }

    public Integer getEnergyNum() {
        return energyNum;
    }

    public void setEnergyNum(Integer energyNum) {
        this.energyNum = energyNum;
    }

    public Integer getWaterNum() {
        return waterNum;
    }

    public void setWaterNum(Integer waterNum) {
        this.waterNum = waterNum;
    }

    public BigDecimal getEnergyUnit() {
        return energyUnit;
    }

    public void setEnergyUnit(BigDecimal energyUnit) {
        this.energyUnit = energyUnit;
    }

    public BigDecimal getWaterUnit() {
        return waterUnit;
    }

    public void setWaterUnit(BigDecimal waterUnit) {
        this.waterUnit = waterUnit;
    }

    public Integer getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Integer roomStatus) {
        this.roomStatus = roomStatus;
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