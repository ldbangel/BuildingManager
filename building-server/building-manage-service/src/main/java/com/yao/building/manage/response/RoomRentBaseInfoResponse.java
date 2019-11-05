package com.yao.building.manage.response;

import lombok.Data;

@Data
public class RoomRentBaseInfoResponse {
    private Integer roomId;
    private String villageName;
    private String buildingName;
    private Integer roomNo;
    private Integer rent;
    private Integer energyUseCount;
    private Integer waterUseCount;
    private Integer manageFee;
    /**
     * 房间类型
     */
    private Integer roomType;
    /**
     * 房间类型描述
     */
    private String roomTypeDesc;
    private Integer openInternet;
    private String readTime;
    private String reportTime;
    private String operator;
}
