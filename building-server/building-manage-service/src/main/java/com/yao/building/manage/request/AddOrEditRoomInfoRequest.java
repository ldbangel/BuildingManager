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
    /**
     * 房间类型  1：住房  2：
     */
    private Integer roomType;
}
