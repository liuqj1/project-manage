package com.example.science.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.science.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    public void addRole(@Param("roleid")Integer roleid,@Param("pid")Integer pid);

    public void deleteRole(@Param("roleid")Integer roleid,@Param("pid")Integer pid);

    public Role checkRole(@Param("roleid")Integer roleid,@Param("pid")Integer pid);
}
