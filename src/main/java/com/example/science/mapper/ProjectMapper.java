package com.example.science.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.science.dto.AuditProjectDto;
import com.example.science.entity.Project;
import com.github.yulichang.base.MPJBaseMapper;
import com.github.yulichang.query.MPJQueryWrapper;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProjectMapper extends MPJBaseMapper<Project> {

    public List<Project> getMyProjects(@Param("username") String username);

    public List<Project> getInvolvedProject(@Param("username") String username);

    public List<Project> getInvolvedProjectStatus2(@Param("username") String username);

    public List<Project> getAllProjects();

    public List<Project>getMyProjectAchievement(@Param("username") String username);

    public List<Project>getMyInvolvedProjectAchievement(@Param("username")String username);

    public void updateProjectStatus(@Param("id")Integer id,@Param("status")Integer status);

    public void declareProject(Project project);

    public List<Project>getProjectView(@Param("id")Integer id);

    public List<Project>getProjectAchievement(@Param("id")Integer id);

    public void updateProjectBudget(@Param("id")Integer id,@Param("budget")Integer budget);

    public List<Project> fetchAchievementWithStatus();

    public List<Project> fetchProjectWithStatus();
}
