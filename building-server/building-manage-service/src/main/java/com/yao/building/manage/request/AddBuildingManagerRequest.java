package com.yao.building.manage.request;

import lombok.Data;

@Data
public class AddBuildingManagerRequest {
    private Integer buildingId;
    private String username;
    private String userMobile;
    private String userIdCard;
}
