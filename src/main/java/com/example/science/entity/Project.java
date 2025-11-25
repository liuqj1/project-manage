package com.example.science.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 项目数据
 * </p>
 *
 * @author lsy
 * @since 2024-04-06
 */
@ApiModel(value = "Project对象", description = "项目数据")
@Data
//@TableName("project")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("项目编号")
    private Integer id;

    @ApiModelProperty("项目名称")
    private String projectName;

    @ApiModelProperty("项目队伍ID")
    private Integer teamid;

    @ApiModelProperty("项目简介")
    private String introduce;

    @ApiModelProperty("预算")
    private Double budget;

    @ApiModelProperty("项目已报销金额")
    private Double expend;

    @ApiModelProperty("项目状态(1申报/2立项/3结题/0不通过)")
    private String status;

    @ApiModelProperty("项目申报时间")
//    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date declarationTime;

    @ApiModelProperty("项目负责人姓名")
    private String chargeUserNickname;

    @ApiModelProperty("成果数量")
    private Integer achievementCount;

    @ApiModelProperty("团队名称")
    private String teamname;

    @ApiModelProperty("外观专利数量")
    private Integer appearanceCount;

    @ApiModelProperty("实用专利数量")
    private Integer utilityCount;

    @ApiModelProperty("发明专利数量")
    private Integer inventionCount;

    @ApiModelProperty("发明专利数量")
    private Integer softwareCount;

    @ApiModelProperty("论文数量")
    private Integer paperCount;

    //状态的项目数
    private Integer statusCount;

    private String chargerid;
}
