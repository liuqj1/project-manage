package com.example.science.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
@Data
@TableName("expend_record")
public class Expend implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer projectId;

    private String username;

    private Double expend;

    private Integer status;


    //@JsonFormat(pattern = "yyyy-MM-dd")
    //使用后日期-1天？？？？？？
    private Date declarationTime;

    private String description;

    private String reimburseUserNickname;

    private String projectName;

    private Double usedExpend;
}

