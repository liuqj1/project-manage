package com.example.science.dto;


import com.example.science.entity.Role;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserRoleDto {

    private String username;

    private String nickname;

    private List<Role> roles = new ArrayList<>();

    //当前状态：0禁用/1启用
    private Integer status;

    //权限等级 管理员/科研人员/负责人
    private String roleLevel;


}
