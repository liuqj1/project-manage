package com.example.science.controller;

import com.example.science.entity.Task;
import com.example.science.service.TaskService;
import com.example.science.util.exception.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task-api")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/get-project-task")
    public ResponseEntity<ErrorResponse>getProjectTask(@RequestParam(value = "projectid")Integer projectid)
    {
        List<Task>list=taskService.getProjectTask(projectid);
        return  ErrorResponse.success(list);
    }

    @GetMapping("/assign-task")
    public String assignTask(@RequestParam(value = "id" )Integer id,@RequestParam(value = "username") String username)
    {
        taskService.assignTask(id,username);
        return "success!";
    }

    @PostMapping("/add-task")
    public String addTask(@RequestBody Task task)
    {
        taskService.addTask(task);
        return "success!";
    }

    @GetMapping("/get-myProject-task")
    public ResponseEntity<ErrorResponse> getMyProjectTask(@RequestParam(value = "projectid")Integer projectid,@RequestParam(value = "username")String username)
    {
        List<Task> list=taskService.getMyProjectTask(projectid,username);
        return  ErrorResponse.success(list);
    }
}
