package com.yao.building.manage.web.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.yao.building.manage.domain.Employee;
import org.springframework.stereotype.Service;

@Service("TokenService")
public class TokenService {
    public String getToken(Employee employee) {
        String token="";
        token= JWT.create().withAudience(employee.getId().toString())// 将 employee id 保存到 token 里面
                .sign(Algorithm.HMAC256(employee.getPassword()));// 以 password 作为 token 的密钥
        return token;
    }
}
