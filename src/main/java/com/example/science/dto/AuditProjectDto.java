package com.example.science.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;

@Data
//@TableName("project")
public class AuditProjectDto {

    @ApiModelProperty("项目编号")
    private Integer id;

    @ApiModelProperty("项目名称")
    private String projectName;

    @ApiModelProperty("预算")
    private Double budget;

    @ApiModelProperty("项目申报时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date declarationTime;

    @ApiModelProperty("负责人名称")
    private String chargeUserNickname;


}
