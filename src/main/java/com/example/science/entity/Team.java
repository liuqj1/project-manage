package com.example.science.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Team implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "teamid", type = IdType.AUTO)
    private Integer teamid;

    private String teamname;

    private String chargerid;

    @ApiModelProperty("项目负责人姓名")
    private String chargeUserNickname;
}
