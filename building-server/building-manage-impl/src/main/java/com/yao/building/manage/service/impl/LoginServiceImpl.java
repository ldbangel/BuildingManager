package com.yao.building.manage.service.impl;

import com.yao.building.manage.dao.EmployeeDao;
import com.yao.building.manage.domain.Employee;
import com.yao.building.manage.domain.EmployeeExample;
import com.yao.building.manage.exception.BuildingErrorCode;
import com.yao.building.manage.exception.BuildingException;
import com.yao.building.manage.request.EmployeeLoginRequest;
import com.yao.building.manage.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("loginService")
@Slf4j
public class LoginServiceImpl implements LoginService {
    @Autowired
    private EmployeeDao employeeDao;

    public Employee employeeLogin(EmployeeLoginRequest request) {
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andEmployeeMobileEqualTo(request.getEmployeeMobile());
        criteria.andStatusEqualTo(1);

        List<Employee> employees = employeeDao.selectByExample(employeeExample);
        if(CollectionUtils.isEmpty(employees)){
            log.info("员工信息不存在，mobile = {}", request.getEmployeeMobile());
            throw new BuildingException(BuildingErrorCode.INVALID_PARAMS);
        }
        Employee employee = employees.get(0);
        return employee;
    }

    public void employeeSignOut() {
    }
}
