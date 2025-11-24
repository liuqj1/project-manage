package com.example.science.service;

import com.example.science.dto.UserProjectNumDto;
import com.example.science.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lsy
 * @since 2024-01-24
 */
public interface UserService extends IService<User> {

    public Map<String,Object> login(String username, String password);

    public Map<String,Object> getInfo(String username);

    public List<UserProjectNumDto> getUserChargeProjectNum();

    public List<UserProjectNumDto>getUserInvolvedProjectNum();

    public List<UserProjectNumDto>getUserCount();

    public List<User>getUserData();
    public void addUser(User user);

    public void resetPassword(String username);

    public void deleteUser(String username);

    public List<User>getProjectUser(Integer projectid);

    public User getMyInfo(String username);

    public void updateInfo(User user);
}
