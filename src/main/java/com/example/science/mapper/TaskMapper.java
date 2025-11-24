package com.example.science.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.science.entity.Task;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TaskMapper extends BaseMapper<Task> {
    public List<Task>getProjectTask(@Param("projectid")Integer projectid);

    public void assignTask(@Param("id")Integer id,@Param("username")String username);

    public void addTask(Task task);

    public List<Task>getMyProjectTask(@Param("projectid")Integer projectid,@Param("username")String username);
}
