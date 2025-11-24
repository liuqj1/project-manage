package com.example.science.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.science.dto.MyTeamDto;
import com.example.science.entity.Team;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface TeamMapper extends BaseMapper<Team> {
    public List<Team> getMyChargedTeam(@Param("username")String username);

    public List<MyTeamDto> getMyTeam(@Param("username")String username);

    public List<String> getTeamMembers(Integer teamId);

    public Integer addMyChargedTeam(@Param("map") Map<String,Object> map);

    public Integer getNewTeamId();

    public Integer updateTeam(@Param("map") Map<String,Object> map);

    public Integer addTeamMembers(@Param("teamId") Integer teamId,@Param("username") String username);
}
