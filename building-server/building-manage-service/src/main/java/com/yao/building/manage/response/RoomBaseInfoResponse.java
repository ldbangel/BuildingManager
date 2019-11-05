package com.yao.building.manage.response;

import lombok.Data;

@Data
public class RoomBaseInfoResponse extends BaseResponse {
    private Integer roomNo;
    private Integer roomType;
    private String roomTypeDesc;
}
