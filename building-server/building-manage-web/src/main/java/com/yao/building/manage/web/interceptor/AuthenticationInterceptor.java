package com.yao.building.manage.web.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.yao.building.manage.component.RedisUtils;
import com.yao.building.manage.domain.Employee;
import com.yao.building.manage.service.EmployeeService;
import com.yao.building.manage.web.annotation.PassToken;
import com.yao.building.manage.web.annotation.UserLoginToken;
import com.yao.building.manage.exception.BuildingErrorCode;
import com.yao.building.manage.exception.BuildingException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 拦截器
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RedisUtils redisUtils;

    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object object) throws Exception {
        // 从 http 请求头中取出 token
        String token = httpServletRequest.getHeader("token");
        // 如果不是映射到方法直接通过
        if(!(object instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod)object;
        Method method=handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (token == null) {
                    throw new BuildingException(BuildingErrorCode.INVALID_TOKEN);
                }
                // 获取 token 中的 employee id
                Employee employee;
                boolean isValid;
                try {
                    String employeeString = JWT.decode(token).getAudience().get(0);
                    employee = JSONObject.parseObject(employeeString, Employee.class);
                    isValid = redisUtils.hasKey(employee.getEmployeeMobile()+"_"+employee.getId());
                } catch (JWTDecodeException j) {
                    throw new BuildingException(BuildingErrorCode.INVALID_TOKEN);
                }
                // redis里面无对应token，判为无效token
                if(!isValid){
                    throw new BuildingException(BuildingErrorCode.INVALID_TOKEN);
                }else{
                    String redisToken = redisUtils.get(employee.getEmployeeMobile()+"_"+employee.getId()).toString();
                    if(!StringUtils.equals(redisToken, token)){
                        throw new BuildingException(BuildingErrorCode.INVALID_TOKEN);
                    }
                }

                employee = employeeService.findEmployeeById(employee.getId());
                if (employee == null) {
                    throw new RuntimeException("用户不存在，请重新登录");
                }
                // 验证 token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(employee.getPassword())).build();
                try {
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    throw new BuildingException(BuildingErrorCode.INVALID_TOKEN);
                }
                return true;
            }
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }


    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse response, Object o, Exception e) throws Exception {
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, X-Requested-With, token");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, OPTIONS, POST, PUT, DELETE");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Max-Age", "1800");
    }
}
