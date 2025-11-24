package com.example.science.mapper;

import com.example.science.dto.UserProjectNumDto;
import com.example.science.entity.Role;
import com.example.science.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lsy
 * @since 2024-01-24
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    public List<Role> getOneRoleList(@Param("roleId")Integer roleId);

    public List<UserProjectNumDto> getUserChargeProjectNum();

    public List<UserProjectNumDto> getUserInvolvedProjectNum();

    public void updateNowUser(@Param("username")String username);

    public List<UserProjectNumDto> getUserCount();

    public List<User> getUserData();

    public void addUser(User user);

    public void resetUserPassword(@Param("username")String username);

    public void deleteUser(@Param("username")String username);

    public List<User>getProjectUser(@Param("projectid")Integer projectid);

    public User getMyInfo(@Param("username")String username);

    public void updateInfo(User user);

    public void updateUserRole(@Param("username")String username,@Param("roleid")Integer roleid);
}
