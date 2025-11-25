package com.example.science.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.science.dto.AuditProjectDto;
import com.example.science.entity.Project;
import com.github.yulichang.base.MPJBaseService;
import io.swagger.models.auth.In;

import java.util.List;

public interface ProjectService extends MPJBaseService<Project> {
    //返回工号为username的所有项目
    public List<Project> getMyAllProjects(String username);

    public List<Project> getMyInvolvedProject(String username);

    public List<Project> getInvolvedProjectStatus2(String username);

    public List<Project> getAllProjects();

    public List<Project>getMyProjectAchievement(String username);

    public List<Project>getMyInvolvedProjectAchievement(String username);

    public void updateProjectStatus(Integer id,Integer status);

    public void declareProject(Project project);

    public List<Project>getProjectView(Integer id);

    public List<Project>getProjectAchievement(Integer id);

    public void updateProjectBudget(Integer id,Integer budget);

    public List<Project> getAchievementWithStatus();

    public List<Project> getProjectWithStatus();

    public void updateUserRole(String username,Integer roleid);
}
