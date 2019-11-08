package com.yao.building.manage.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RoomBaseInfoResponse extends BaseResponse {
    private Integer roomNo;
    private Integer roomType;
    private String roomTypeDesc;
    private Integer rent;
    private BigDecimal energyUnit;
    private BigDecimal waterUnit;
}
