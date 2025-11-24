package com.example.science.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.models.auth.In;
import lombok.Data;

@Data
public class Role {

    //权限名称
    private String title;

    private Integer roleid;
    private Integer pid;

}
