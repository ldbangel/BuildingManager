package com.yao.building.manage.service;

import com.yao.building.manage.domain.Employee;
import com.yao.building.manage.request.EmployeeLoginRequest;

/**
 * 员工登录、退出
 */
public interface EmployeeLoginService {
    public Employee employeeLogin(EmployeeLoginRequest request);

    public void employeeSignOut();
}
