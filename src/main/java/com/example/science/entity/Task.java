package com.example.science.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.models.auth.In;
import lombok.Data;

@Data
public class Task {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer projectid;

    private String content;

    private String username;

    private String nickname;

}
