package com.example.science.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.science.entity.User;
import com.example.science.mapper.UserMapper;
import com.example.science.service.UserService;
import com.example.science.util.exception.BaseException;
import com.example.science.util.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("Authorization");
        // 如果不是映射到方法则跳过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        //进行token检查
        if (StrUtil.isBlank(token)) {
            throw new BaseException(ErrorCode.UNAUTHORIZED,null);
//            throw new ErrorResponse(ErrorCode.UNAUTHORIZED);
        }

        String username;
        try {
           // System.out.println("JWTFilter中的参数："+JWT.decode(token).getAudience());
            username = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            throw new BaseException(ErrorCode.AUTHORIZED_ERROR,null);
        }
//        System.out.println(username);
        //根据token中的username查询数据库
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        User user = userService.getOne(wrapper);
//        System.out.println(user);
        if (user == null) {
            // 查询该token中负载携带的用户username是否存在
            throw new BaseException(ErrorCode.USER_NOT_EXISTED,null);
        }

        //用户密码加签验证验证token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new BaseException(ErrorCode.AUTHORIZED_ERROR,null);
        }

        //合法则插数据,表示发送该请求的人
        userMapper.updateNowUser(username);

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
