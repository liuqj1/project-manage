package com.example.science.dto;

import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
public class MyTeamDto {

    private Integer teamId;

    private String teamName;

    private String chargerId;

    private String chargerName;

    private List<String> membersName = new ArrayList<>();

    private String projectName;

    private String status;

    private Double budget;

    private Date declarationTime;


}
