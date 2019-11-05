package com.yao.building.manage.response;

import lombok.Data;

@Data
public class RoomAndDataInfoResponse extends BaseResponse{
    private Integer rent;
    private Integer energyNum;
    private Integer waterNum;
    private Integer manageFee;

    /**
     * 是否开通网络   0：未开通     1：开通
     */
    private Integer openInternet;
    private String readTime;
    private String operator;
}
