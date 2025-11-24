package com.example.science.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
@TableName("achievement_record")
public class Achievement implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer projectid;

    private Integer typeid;

    private String typename;

    private String description;

    private Integer quality;

    private Integer status;

    private String username;


    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date declarationTime;

    @ApiModelProperty("某个成果的数量")
    private Integer count;

    private String nickName;
}
