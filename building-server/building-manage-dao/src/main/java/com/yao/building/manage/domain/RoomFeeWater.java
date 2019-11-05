package com.yao.building.manage.domain;

import java.math.BigDecimal;
import java.util.Date;

public class RoomFeeWater {
    private Integer id;

    private Integer index;

    private Integer roomId;

    private Integer rentFee;

    private BigDecimal energyFee;

    private BigDecimal waterFee;

    private Integer manageFee;

    private Integer cleanFee;

    private Integer internetFee;

    private BigDecimal allFee;

    private Integer payStatus;

    private Date startFeeTime;

    private Date endFeeTime;

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

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getRentFee() {
        return rentFee;
    }

    public void setRentFee(Integer rentFee) {
        this.rentFee = rentFee;
    }

    public BigDecimal getEnergyFee() {
        return energyFee;
    }

    public void setEnergyFee(BigDecimal energyFee) {
        this.energyFee = energyFee;
    }

    public BigDecimal getWaterFee() {
        return waterFee;
    }

    public void setWaterFee(BigDecimal waterFee) {
        this.waterFee = waterFee;
    }

    public Integer getManageFee() {
        return manageFee;
    }

    public void setManageFee(Integer manageFee) {
        this.manageFee = manageFee;
    }

    public Integer getCleanFee() {
        return cleanFee;
    }

    public void setCleanFee(Integer cleanFee) {
        this.cleanFee = cleanFee;
    }

    public Integer getInternetFee() {
        return internetFee;
    }

    public void setInternetFee(Integer internetFee) {
        this.internetFee = internetFee;
    }

    public BigDecimal getAllFee() {
        return allFee;
    }

    public void setAllFee(BigDecimal allFee) {
        this.allFee = allFee;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Date getStartFeeTime() {
        return startFeeTime;
    }

    public void setStartFeeTime(Date startFeeTime) {
        this.startFeeTime = startFeeTime;
    }

    public Date getEndFeeTime() {
        return endFeeTime;
    }

    public void setEndFeeTime(Date endFeeTime) {
        this.endFeeTime = endFeeTime;
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