package com.example.science.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 *
 * </p>
 *
 * @author lsy
 * @since 2024-04-06
 */
@TableName("ums_user")
@ApiModel(value = "User对象", description = "")
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    //@TableId(value = "username", type = IdType.AUTO)
    @ApiModelProperty("工号（也是登录账号）")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "用户密码不能为空")
    private String password;

    @ApiModelProperty("用户真实姓名")
    private String nickname;

    private String gender;

    private String phone;

    private String email;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("用户创建时间")
    private Date creatTime;

    @ApiModelProperty("登录时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date loginTime;

    @ApiModelProperty("用户角色(0超级管理员，1科研人员，2项目负责人，3科研机构管理员)")
    private Integer roleid;


    @ApiModelProperty("当前状态（0禁用，1启用）")
    private Integer status;


}
