package com.example.science.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.science.entity.Task;
import com.example.science.mapper.TaskMapper;
import com.example.science.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task>implements TaskService {

    @Autowired
    private TaskMapper taskMapper;
    @Override
    public List<Task> getProjectTask(Integer projectid) {
        List<Task>list=taskMapper.getProjectTask(projectid);
        return list;
    }

    @Override
    public void assignTask(Integer id, String username) {
        taskMapper.assignTask(id,username);
    }

    @Override
    public void addTask(Task task)
    {
        taskMapper.addTask(task);
    }

    @Override
    public List<Task> getMyProjectTask(Integer projectid, String username) {
        List<Task>list=taskMapper.getMyProjectTask(projectid,username);
        return list;
    }

}
