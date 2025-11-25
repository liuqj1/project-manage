package com.example.science.controller;

import com.example.science.entity.Role;
import com.example.science.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role-api")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/add-role")
    public String addRole(@RequestParam(value = "roleid")Integer roleid,@RequestParam(value = "pid")Integer pid)
    {
        roleService.addRole(roleid,pid);
        return "success!";
    }

    @GetMapping("/delete-role")
    public String deleteRole(@RequestParam(value = "roleid")Integer roleid,@RequestParam(value = "pid")Integer pid)
    {
        roleService.deleteRole(roleid,pid);
        return "success!";
    }

    @GetMapping("/check-role")
    public String check(@RequestParam(value = "roleid")Integer roleid,@RequestParam(value = "pid")Integer pid)
    {
        Role role=roleService.checkRole(roleid,pid);
        if(role!=null)
            return "true";
        else return "false";
    }
}
