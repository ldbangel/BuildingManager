package com.yao.building.manage.response;

import lombok.Data;

@Data
public class BaseResponse {
    private Integer roomId;
    private Integer buildingId;
    private String cityName;
    private String areaName;
    private String streetName;
    private String villageName;
    private String buildingName;
    private Integer roomNo;
    private String rentStatus;
}
