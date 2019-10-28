package com.yao.building.manage.response;

import lombok.Data;

@Data
public class RoomAndDataInfoResponse extends BaseResponse{
    private Integer rent;
    private Integer energyNum;
    private Integer waterNum;
    private Integer manageFee;
    private String readTime;
    private String operator;
}
