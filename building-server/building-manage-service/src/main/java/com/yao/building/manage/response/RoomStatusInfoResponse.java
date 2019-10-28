package com.yao.building.manage.response;

import lombok.Data;

@Data
public class RoomStatusInfoResponse extends BaseResponse{
    /**
     * 房间编号
     */
    private Integer roomNo;
    /**
     * 租赁状态
     */
    private String rentStatus;
}
