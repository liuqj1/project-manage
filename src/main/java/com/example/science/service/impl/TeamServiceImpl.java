package com.example.science.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.science.dto.MyTeamDto;
import com.example.science.entity.Team;
import com.example.science.mapper.TeamMapper;
import com.example.science.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team> implements TeamService {



    @Autowired
    private TeamMapper teamMapper;
    @Override
    public List<Team> getMyChargedTeam(String username) {
        List<Team>list=new ArrayList<>();
        list=teamMapper.getMyChargedTeam(username);
        return list;
    }

    @Override
    public List<MyTeamDto> getMyTeam(String username) {
        List<MyTeamDto> myTeamDto = teamMapper.getMyTeam(username);
        for(MyTeamDto dto: myTeamDto){
            dto.setMembersName(teamMapper.getTeamMembers(dto.getTeamId()));
            dto.setStatus(ProjectServiceImpl.projectStatus[Integer.parseInt(dto.getStatus())]);
//            System.out.println(dto);
        }
        //System.out.println("getMyTeam");
        return myTeamDto;
    }

    @Override
    public Integer addMyChargedTeam(Map<String, Object> map) {
        Integer result = 0;
        result = teamMapper.addMyChargedTeam(map);
        //System.out.println(String.valueOf(map.get("chargerId")));
        List<String> members = new ArrayList<>();
        //添加负责人
        members.add(String.valueOf(map.get("chargerId")));
        members.addAll((Collection<String>)map.get("members"));
        Integer teamId = teamMapper.getNewTeamId();
        for(int i=0;i<members.size();i++){
            //System.out.println(members.get(i));
            result = teamMapper.addTeamMembers(teamId,members.get(i));
        }
        return result;
    }

    @Override
    public Integer updateTeam(Map<String, Object> map) {
        return teamMapper.updateTeam(map);
    }
}
