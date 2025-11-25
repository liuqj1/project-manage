package com.example.science.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.science.entity.Role;
import com.example.science.mapper.RoleMapper;
import com.example.science.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public void addRole(Integer roleid, Integer pid) {
        roleMapper.addRole(roleid,pid);
    }

    @Override
    public void deleteRole(Integer roleid, Integer pid) {
        roleMapper.deleteRole(roleid,pid);
    }

    @Override
    public Role checkRole(Integer roleid, Integer pid) {
        return roleMapper.checkRole(roleid,pid);
    }
}
