package com.yao.building.manage.request;

import lombok.Data;

@Data
public class AddOrEditRoomInfoRequest {
    private Integer buildingId;
    private Integer roomId;
    private Integer roomNo;
    private Integer rent;
    private Integer energyNum;
    private Integer waterNum;
}
