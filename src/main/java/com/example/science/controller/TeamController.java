package com.example.science.controller;

import com.example.science.dto.MyTeamDto;
import com.example.science.entity.Team;
import com.example.science.service.TeamService;
import com.example.science.util.exception.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/team-api")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping("/get-myChargedTeam")
    public ResponseEntity<ErrorResponse> getMyChargedTeam(@RequestParam(value = "username")String username)
    {
        List<Team> list=teamService.getMyChargedTeam(username);
        return ErrorResponse.success(list);
    }

    @GetMapping("/get-myTeam")
    public ResponseEntity<ErrorResponse> getMyTeam(@RequestParam(value = "username")String username)
    {
        List<MyTeamDto> list=teamService.getMyTeam(username);
        return ErrorResponse.success(list);
    }

    @PostMapping("/add-myChargedTeam")
    public Integer addMyChargedTeam(@RequestBody Map<String,Object> map)
    {

        return teamService.addMyChargedTeam(map);
    }

    @PostMapping("/update-team")
    public Integer updateTeam(@RequestBody Map<String,Object> map)
    {
//        System.out.println("收到update");
        return teamService.updateTeam(map);
    }

}
