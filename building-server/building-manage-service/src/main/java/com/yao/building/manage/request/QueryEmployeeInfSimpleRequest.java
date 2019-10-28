package com.yao.building.manage.request;

import lombok.Data;

@Data
public class QueryEmployeeInfSimpleRequest {
    private String employeeMobile;
    private Integer employeeId;
}
