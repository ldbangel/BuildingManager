package com.yao.building.manage.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddRoomRentBaseInfoRequest {
    private Integer roomId;
    private Integer energyNum;
    private Integer waterNum;
    /**
     * 是否开通网络   0：不开通    1：开通
     */
    private Integer openInternet;

    /**
     * 水单价
     * 注意：只有房间是档口时需要传
     */
    private BigDecimal waterUnit;

    /**
     * 电单价
     * 注意：只有房间是档口时需要传
     */
    private BigDecimal energyUnit;
    private String readTime;
    private String operator;
}
