package com.yao.building.manage.response;

import lombok.Data;

@Data
public class RoomInfoResponse {
    private Integer roomId;
    private Integer roomNo;
    private Integer rent;
    private Integer energyNum;
    private Integer waterNum;
    private String operator;
}
