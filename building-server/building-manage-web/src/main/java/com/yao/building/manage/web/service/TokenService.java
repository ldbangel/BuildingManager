package com.yao.building.manage.web.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.yao.building.manage.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@Service("TokenService")
public class TokenService {
    public static String getToken(Employee employee) {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.MINUTE, 30);
        Date expires = calendar.getTime();
        String token= JWT.create()
                .withAudience(employee.getId().toString())// 将 employee id 保存到 token 里面
                .withIssuedAt(now)     //当前时间
                .withExpiresAt(expires)       //过期时间
                .sign(Algorithm.HMAC256(employee.getPassword()));// 以 password 作为 token 的密钥

        return token;
    }

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setPassword("1233213");
        employee.setId(12);
        String token = getToken(employee);
        System.out.println(token);
        Date expire = JWT.decode(token).getExpiresAt();
        JWT.decode(token).getAudience().get(0);
    }
}
