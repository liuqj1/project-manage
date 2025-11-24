package com.example.science.service.impl;

//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.science.dto.AuditProjectDto;
import com.example.science.entity.Project;
import com.example.science.entity.User;
import com.example.science.mapper.ProjectMapper;
import com.example.science.mapper.UserMapper;
import com.example.science.service.ProjectService;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.query.MPJQueryWrapper;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl extends MPJBaseServiceImpl<ProjectMapper, Project> implements ProjectService {

    static String[] projectStatus = {"不通过","申报中","已立项","已结题"};

    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Project> getMyAllProjects(String username) {
        List<Project> list = new ArrayList<>();
        //区别两者
//        MPJLambdaWrapper<Project> wrapper = new MPJLambdaWrapper<>();
//        MPJQueryWrapper<Project> wrapper = new MPJQueryWrapper<>();
//        projectMapper.selectList()
                //需要实现联表查询
//        wrapper.selectAll(Project.class)
//                .select("team_user_relation.username")
//                .select("ums_user.nickname as charge_user_nickname")
//                // 主表会被默认为t表
//                .leftJoin("team_user_relation on t.teamid = team_user_relation.teamid")
//                .leftJoin("team on t.teamid = team.teamid")
//                .leftJoin("ums_user on team.chargerid = ums_user.username")
//                .eq("team_user_relation.username",username);
//        list=projectMapper.selectList(wrapper);
        list=projectMapper.getMyProjects(username);

        for(Project p : list){
            if(p!=null&&p.getStatus()!=null)
            p.setStatus(projectStatus[Integer.parseInt(p.getStatus())]);
//            System.out.println(p);
        }
        return list;
    }

    @Override
    public List<Project> getMyInvolvedProject(String username) {
        List<Project> list=projectMapper.getInvolvedProject(username);
        for(Project p : list){
            if(p!=null&&p.getStatus()!=null)
            p.setStatus(projectStatus[Integer.parseInt(p.getStatus())]);
//            System.out.println(p);
        }
        return list;
    }

    @Override
    public List<Project> getInvolvedProjectStatus2(String username) {
        List<Project>list=projectMapper.getInvolvedProjectStatus2(username);
        return list;
    }

    @Override
    public List<Project> getAllProjects() {
        List<Project> list = new ArrayList<>();
        list = projectMapper.getAllProjects();
        for(Project p : list){
            p.setStatus(projectStatus[Integer.parseInt(p.getStatus())]);
//            System.out.println(p);
        }
        return list;
    }



    @Override
    public List<Project> getMyProjectAchievement(String username) {
        List<Project> list = new ArrayList<>();
        list=projectMapper.getMyProjectAchievement(username);
        return list;
    }

    @Override
    public List<Project> getMyInvolvedProjectAchievement(String username) {
        List<Project> list = new ArrayList<>();
        list=projectMapper.getMyInvolvedProjectAchievement(username);
        //for(Project p:list)
            //System.out.println(p);
        return list;
    }

    @Override
    public void updateProjectStatus(Integer id, Integer status) {
        projectMapper.updateProjectStatus(id,status);
    }

    @Override
    public void declareProject(Project project) {
        projectMapper.declareProject(project);
    }

    @Override
    public List<Project> getProjectView(Integer id) {
        List<Project>list=projectMapper.getProjectView(id);
        return list;
    }

    @Override
    public List<Project> getProjectAchievement(Integer id) {
        List<Project>list=projectMapper.getProjectAchievement(id);
        return list;
    }

    @Override
    public void updateProjectBudget(Integer id, Integer budget) {
        projectMapper.updateProjectBudget(id,budget);
    }

    @Override
    public List<Project> getAchievementWithStatus() {
        List<Project>list=projectMapper.fetchAchievementWithStatus();
        return list;
    }

    @Override
    public List<Project> getProjectWithStatus() {
        List<Project>list=projectMapper.fetchProjectWithStatus();
        return list;
    }

    @Override
    public void updateUserRole(String username, Integer roleid) {
        userMapper.updateUserRole(username,roleid);
    }

}
