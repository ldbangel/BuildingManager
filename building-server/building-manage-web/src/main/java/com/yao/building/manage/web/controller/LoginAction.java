package com.yao.building.manage.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.yao.building.manage.domain.Employee;
import com.yao.building.manage.service.EmployeeService;
import com.yao.building.manage.web.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping("/building/access")
@RestController
public class LoginAction {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("login")
    public JSONObject login(@RequestBody Employee employee, HttpServletRequest servletRequest){
        JSONObject jsonObject=new JSONObject();
        Employee employeeBase = employeeService.findEmployeeByMobile(employee);
        HttpSession session = servletRequest.getSession();
        if(employeeBase == null){
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }else{
            if (!employeeBase.getPassword().equals(employee.getPassword())){
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
            }else {
                session.setAttribute("employee", employee);
                String token = tokenService.getToken(employeeBase);
                jsonObject.put("token", token);
                jsonObject.put("username", employeeBase.getEmployeeName());
                jsonObject.put("mobile", employeeBase.getEmployeeMobile());
                return jsonObject;
            }
        }
    }

    @RequestMapping("logout")
    public JSONObject logout(HttpServletRequest servletRequest){
        JSONObject jsonObject=new JSONObject();
        HttpSession session = servletRequest.getSession();
        session.removeAttribute("employee");
        jsonObject.put("message", "success");
        return jsonObject;
    }
}
