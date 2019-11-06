package com.yao.building.manage.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.yao.building.manage.component.RedisUtils;
import com.yao.building.manage.domain.Employee;
import com.yao.building.manage.service.EmployeeService;
import com.yao.building.manage.web.annotation.UserLoginToken;
import com.yao.building.manage.web.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登录退出
 */
@RequestMapping("/building/access")
@RestController
public class LoginAction {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RedisUtils redisUtils;

    private static final long EXPIRE_TIMEOUT = 60*30;

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
                session.setAttribute("employee", employeeBase);
                String token = tokenService.getToken(employeeBase);
                // 缓存到redis
                redisUtils.set(employeeBase.getEmployeeMobile()+"_"+employeeBase.getId(), token, EXPIRE_TIMEOUT);
                jsonObject.put("token", token);
                jsonObject.put("employeeId", employeeBase.getId());
                jsonObject.put("username", employeeBase.getEmployeeName());
                jsonObject.put("mobile", employeeBase.getEmployeeMobile());
                jsonObject.put("employeeRole", employeeBase.getEmployeeRole());
                jsonObject.put("employeeRoleDesc", employeeBase.getEmployeeRoleDesc());
                return jsonObject;
            }
        }
    }

    @UserLoginToken
    @RequestMapping("logout")
    public JSONObject logout(HttpServletRequest servletRequest){
        JSONObject jsonObject=new JSONObject();
        String token = servletRequest.getHeader("token");
        String employeeString = JWT.decode(token).getAudience().get(0);
        Employee employee = JSONObject.parseObject(employeeString, Employee.class);
        redisUtils.del(employee.getEmployeeMobile()+"_"+employee.getId());
        jsonObject.put("message", "success");
        return jsonObject;
    }
}
