package com.example.science.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.science.dto.UserLoginDto;
import com.example.science.dto.UserProjectNumDto;
import com.example.science.dto.UserRoleDto;
import com.example.science.entity.Role;
import com.example.science.entity.User;
import com.example.science.mapper.UserMapper;
import com.example.science.security.JwtUtil;
import com.example.science.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.science.util.exception.BaseException;
import com.example.science.util.exception.ErrorCode;
import io.swagger.models.auth.In;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lsy
 * @since 2024-01-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    static String[] roleLevel = {"超级管理员","科研人员","项目负责人","科研机构管理员"};

    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, Object> login(String username, String password) {
        Map<String, Object> map = new HashMap<>();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        User user = null;
        try{ //可能存在脏数据导致getOne出现异常
            user = this.getOne(wrapper);
            if(Objects.isNull(user)){
                //用户不存在
                System.out.println("login中问题: 用户不存在");
                throw new BaseException(ErrorCode.USER_NOT_EXISTED,null);
            }
            wrapper.eq("password",password);
            user = this.getOne(wrapper);
            if(!user.getPassword().equals(password)){
                //密码错误
                throw new BaseException(ErrorCode.PASSWORD_ERROR,null);
            }
        }catch (Exception e){
            //System.out.println(e);
            System.out.println("存在同username的脏数据");
            throw new BaseException(ErrorCode.SERVER_ERROR,null);
        }
        String token = JwtUtil.generateToken(user.getUsername().toString(),password);
        //更新
        // 获取当前时间的毫秒数
        long millis = System.currentTimeMillis();
        java.util.Date currentDate = new java.util.Date(millis);
        user.setLoginTime(new Date(currentDate.getTime()));
//        wrapper.clear();
//        wrapper.eq("username",username);
        this.update(user,wrapper);
        UserLoginDto userLoginDto = new UserLoginDto();
        BeanUtils.copyProperties(user,userLoginDto);
        userLoginDto.setToken(token);
        map.put("user",userLoginDto);
        return map;
    }

    @Override
    public Map<String, Object> getInfo(String username) {
        Map<String, Object> map = new HashMap<>();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        User user = userMapper.selectOne(wrapper);
//        System.out.println(user);
        UserRoleDto userRoleDto = new UserRoleDto();
        BeanUtils.copyProperties(user,userRoleDto);
        userRoleDto.setRoleLevel(roleLevel[user.getRoleid()]);
        userRoleDto.getRoles().addAll(userMapper.getOneRoleList(user.getRoleid()));
        //.println(userRoleDto);
        map.put("userInfo",userRoleDto);
        return map;
    }

    @Override
    public List<UserProjectNumDto> getUserChargeProjectNum() {
        List<UserProjectNumDto> list=userMapper.getUserChargeProjectNum();
        return list;
    }

    @Override
    public List<UserProjectNumDto> getUserInvolvedProjectNum() {
        List<UserProjectNumDto> list=userMapper.getUserInvolvedProjectNum();
        return list;
    }

    @Override
    public List<UserProjectNumDto> getUserCount() {
        List<UserProjectNumDto> list=userMapper.getUserCount();
        return list;
    }

    @Override
    public List<User> getUserData() {
        List<User>list=userMapper.getUserData();
        return list;
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void resetPassword(String username) {
        userMapper.resetUserPassword(username);
    }

    @Override
    public void deleteUser(String username) {
        userMapper.deleteUser(username);
    }

    @Override
    public List<User> getProjectUser(Integer projectid) {
       List<User>list= userMapper.getProjectUser(projectid);
        return list;
    }

    @Override
    public User getMyInfo(String username) {
       User user= userMapper.getMyInfo(username);
        return user;
    }

    @Override
    public void updateInfo(User user) {
        userMapper.updateInfo(user);
    }


}
