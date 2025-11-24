package com.example.science.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.science.entity.Task;
import io.swagger.models.auth.In;

import java.util.List;

public interface TaskService extends IService<Task> {

    public List<Task> getProjectTask(Integer projectid);

    public void assignTask(Integer id,String username);

    public void addTask(Task task);

    public List<Task> getMyProjectTask(Integer projectid,String username);
}
