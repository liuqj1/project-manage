package com.example.science.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.science.entity.Role;

public interface RoleService extends IService<Role> {
    public void addRole(Integer roleid,Integer pid);

    public void deleteRole(Integer roleid,Integer pid);

    public Role checkRole(Integer roleid,Integer pid);
}
