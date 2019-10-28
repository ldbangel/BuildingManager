package com.yao.building.manage.request;

import lombok.Data;

@Data
public class ModifyEmployeeInfoRequest {
    private Integer employeeId;
    private String password;
}
