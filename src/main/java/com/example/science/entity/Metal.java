package com.example.science.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
//数据库中的下划线对应实体时采用驼峰命名法
public class Metal {

//    @NotBlank(message = "金属名不能为空")
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;//修改

    private Double openingPrice;

    private Double maximumPrice;

    private Double minimumPrice;

    private Double closingPrice;

    private Double turnover;

}
