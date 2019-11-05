package com.yao.building.manage.response;

import lombok.Data;

@Data
public class BaseResponse {
    /**
     * 房间Id
     */
    private Integer roomId;

    /**
     * 楼栋Id
     */
    private Integer buildingId;

    /**
     * 城市
     */
    private String cityName;

    /**
     * 区
     */
    private String areaName;

    /**
     * 街道
     */
    private String streetName;

    /**
     * 村名
     */
    private String villageName;

    /**
     * 楼栋名称
     */
    private String buildingName;

    /**
     * 房间编号
     */
    private Integer roomNo;

    /**
     * 房间状态
     */
    private String rentStatus;

    /**
     * 管理费
     */
    private Integer manageFee;

    /**
     * 卫生费
     */
    private Integer cleanFee;

    /**
     * 网费
     */
    private Integer internetFee;

    /**
     * 房间类型
     */
    private Integer roomType;

    /**
     * 房间类型描述
     */
    private String roomTypeDesc;
}
