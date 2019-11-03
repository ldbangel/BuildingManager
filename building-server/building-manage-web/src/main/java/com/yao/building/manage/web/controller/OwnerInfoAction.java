package com.yao.building.manage.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.yao.building.manage.domain.Employee;
import com.yao.building.manage.request.ModifyEmployeeInfoRequest;
import com.yao.building.manage.request.QueryEmployeeInfSimpleRequest;
import com.yao.building.manage.service.EmployeeService;
import com.yao.building.manage.web.annotation.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/building/owner")
@RestController
public class OwnerInfoAction {
    @Autowired
    private EmployeeService employeeInfoService;

    /**
     * 获取员工个人信息
     */
    @UserLoginToken
    @RequestMapping("getOwnerInfo")
    public Employee getEmployeeOwnerInfo(@RequestBody QueryEmployeeInfSimpleRequest request){
        Employee employee = employeeInfoService.queryEmployeeInfoSimple(request);
        return employee;
    }

    /**
     * 编辑个人信息
     */
    @UserLoginToken
    @RequestMapping("editOwnerInfo")
    public JSONObject editEmployeeOwnerInfo(@RequestBody ModifyEmployeeInfoRequest request){
        JSONObject response = new JSONObject();
        employeeInfoService.modifyEmployeeInfo(request);
        response.put("status", "success");
        return response;
    }
}
