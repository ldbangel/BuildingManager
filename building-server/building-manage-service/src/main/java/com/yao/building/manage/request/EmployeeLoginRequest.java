package com.yao.building.manage.request;

import lombok.Data;

@Data
public class EmployeeLoginRequest {
    private String employeeMobile;
    private String password;
}
