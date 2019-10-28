package com.yao.building.manage.request;

import lombok.Data;

@Data
public class AddRoomRentBaseInfoRequest {
    private Integer roomId;
    private Integer energyNum;
    private Integer waterNum;
    private String readTime;
    private String operator;
}
