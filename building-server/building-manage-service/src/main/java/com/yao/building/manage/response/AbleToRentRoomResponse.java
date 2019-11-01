package com.yao.building.manage.response;

import lombok.Data;

@Data
public class AbleToRentRoomResponse {
    private Integer roomId;
    private String villageName;
    private String buildingName;
    private Integer roomNo;
    private String rentStatus;
}
