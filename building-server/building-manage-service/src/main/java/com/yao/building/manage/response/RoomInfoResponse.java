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
    /**
     * 房间类型  1：住房  2：档口
     */
    private Integer roomType;

    /**
     * 类型描述
     */
    private String roomTypeDesc;
}
