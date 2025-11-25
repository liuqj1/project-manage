package com.example.science.controller;

import com.example.science.dto.AuditProjectDto;
import com.example.science.entity.Project;
import com.example.science.entity.Team;
import com.example.science.service.ProjectService;
import com.example.science.util.exception.ErrorResponse;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/project-api")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/get-myProjects")
    public ResponseEntity<ErrorResponse> getMyProjects(@RequestParam(value = "username") String username)
    {
//        System.out.println("收到的参数："+username);
        List<Project> list=projectService.getMyAllProjects(username);
        return ErrorResponse.success(list);
    }
    @GetMapping("/get-myInvolvedProjects")
    public ResponseEntity<ErrorResponse> getMyInvolvedProjects(@RequestParam(value = "username") String username)
    {
        List<Project>list=projectService.getMyInvolvedProject(username);
        return ErrorResponse.success(list);
    }

    @GetMapping("/get-myInvolvedProjects-status2")
    public ResponseEntity<ErrorResponse> getMyInvolvedProjectStatus2(@RequestParam(value = "username") String username)
    {
        List<Project>list=projectService.getInvolvedProjectStatus2(username);
        return ErrorResponse.success(list);
    }

    @GetMapping("/get-allProjects")
    public ResponseEntity<ErrorResponse> getAllProjects()
    {
        List<Project> list=projectService.getAllProjects();
        return ErrorResponse.success(list);
    }

    @GetMapping("/get-myProject-achievement")
    public ResponseEntity<ErrorResponse>getMyProjectAchievement(@RequestParam(value = "username") String username)
    {
        List<Project> list=projectService.getMyProjectAchievement(username);
        return ErrorResponse.success(list);
    }

    @GetMapping("/get-myInvolvedProject-achievement")
    public ResponseEntity<ErrorResponse>getMyInvolvedProjectAchievement(@RequestParam(value = "username") String username)
    {
        //System.out.println("get-myInvolvedProject-achievement");
        List<Project> list=projectService.getMyInvolvedProjectAchievement(username);
        return ErrorResponse.success(list);
    }

    @PostMapping("/update-project-status")
    public void concludeMyProject(@RequestParam(value = "id") Integer id,@RequestParam(value = "status")Integer status)
    {
        //System.out.println("修改项目状态"+status);
        projectService.updateProjectStatus(id,status);
    }

    @PostMapping("/declare-project")
    public String declareProject(@RequestBody Project project)
    {
        projectService.declareProject(project);
        return "success!";
    }

    @GetMapping("/get-project-view")
    public ResponseEntity<ErrorResponse>getProjectView(@RequestParam(value = "id") Integer projectId)
    {
        List<Project>list=projectService.getProjectView(projectId);
        //System.out.println(list.get(0).getChargerid());
        projectService.updateUserRole(list.get(0).getChargerid(),2);
        return ErrorResponse.success(list);

    }

    @GetMapping("/get-project-achievement")
    public ResponseEntity<ErrorResponse>getProjectAchievement(@RequestParam(value = "id") Integer projectId)
    {
        List<Project>list=projectService.getProjectAchievement(projectId);
        return ErrorResponse.success(list);
    }

    @PostMapping("/update-project-budget")
    public String updateProjectBudget(@RequestParam(value = "id") Integer id,@RequestParam(value = "budget")Integer budget)
    {
        projectService.updateProjectBudget(id,budget);
        return "success!";
    }

    @GetMapping("/get-achievement-with-status")
    public ResponseEntity<ErrorResponse>fetchAchievementWithStatus()
    {
        List<Project>list=projectService.getAchievementWithStatus();
        return ErrorResponse.success(list);
    }

    @GetMapping("/get-project-with-status")
    public  ResponseEntity<ErrorResponse>fetchProjectWithStatus()
    {
        List<Project>list=projectService.getProjectWithStatus();
        return ErrorResponse.success(list);
    }

}
