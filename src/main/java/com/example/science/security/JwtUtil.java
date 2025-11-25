package com.example.science.security;


import cn.hutool.core.date.DateUtil;
import com.example.science.entity.User;
import com.example.science.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;


// JJWT see: https://blog.csdn.net/u013225431/article/details/131342616
// JWT  see: https://blog.csdn.net/weixin_67958017/article/details/128856282

@Component
public class JwtUtil {

    private static UserService staticUserService;
    @Autowired
    private UserService userService;

    @PostConstruct
    public void setUserService(){
        staticUserService = userService;
    }

    //生成token
    public static String generateToken(String userId, String sign) {
        return JWT.create().withAudience(userId) // 将 user id 保存到 token 里面,作为载荷
                .withExpiresAt(DateUtil.offsetHour(new Date(),1)) // 1小时后token过期
                .sign(Algorithm.HMAC256(sign)); // 以 password 作为 token 的密钥


    }

    //获取当前用户对象信息
    public static User getCurrentUser(){
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

            String token = request.getHeader("token");
            if (StrUtil.isNotBlank(token)){

                String userId = JWT.decode(token).getAudience().get(0);
                return staticUserService.getById(Integer.valueOf(userId));
            }
        } catch (Exception e) {
            return null;
        }

        return null;

    }


}
