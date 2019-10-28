package com.yao.building.manage.request;

import lombok.Data;

@Data
public class CancelRoomRentRequest {
    private Integer roomId;
    private Integer energyNum;
    private Integer waterNum;
    private String rentEndTime;
    private String operator;
}
