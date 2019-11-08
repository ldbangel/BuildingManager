package com.yao.building.manage.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddOrEditRoomInfoRequest {
    private Integer buildingId;
    private Integer roomId;
    private Integer roomNo;
    private Integer rent;
    private Integer energyNum;
    private Integer waterNum;
    private BigDecimal energyUnit;
    private BigDecimal waterUnit;
    /**
     * 房间类型  1：住房  2：
     */
    private Integer roomType;
}
