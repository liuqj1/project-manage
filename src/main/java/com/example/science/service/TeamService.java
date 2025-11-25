package com.example.science.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.science.dto.MyTeamDto;
import com.example.science.entity.Team;

import java.util.List;
import java.util.Map;

public interface TeamService extends IService<Team> {
    public List<Team> getMyChargedTeam(String username);

    public List<MyTeamDto> getMyTeam(String username);

    public Integer addMyChargedTeam(Map<String,Object> map);

    public Integer updateTeam(Map<String,Object> map);

}
