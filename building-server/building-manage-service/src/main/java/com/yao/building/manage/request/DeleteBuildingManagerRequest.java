package com.yao.building.manage.request;

import lombok.Data;

@Data
public class DeleteBuildingManagerRequest {
    private Integer buildingId;
    private Integer employeeId;
}
