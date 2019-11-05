package com.yao.building.manage.request;

import lombok.Data;

@Data
public class AddOrEditBuildingInfoRequest {
    private Integer buildingId;
    private Integer cityId;
    private Integer areaId;
    private Integer streetId;
    private Integer villageId;
    private String buildingName;
    private Integer manageFee;
    /**
     * 卫生费
     */
    private Integer cleanFee;

    /**
     * 网费
     */
    private Integer internetFee;
}
