package com.example.science.dto;

import io.swagger.models.auth.In;
import lombok.Data;

@Data
public class UserProjectNumDto {

    private Integer userNum;
    private Integer manNum;
    private Integer womanNum;
    private String username;
    private String nickname;
    private Integer chargeProjectNum;
    private Integer involvedProjectNum;
}
