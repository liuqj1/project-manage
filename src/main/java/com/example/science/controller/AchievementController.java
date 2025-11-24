package com.example.science.controller;

import com.example.science.entity.Achievement;
import com.example.science.service.AchievementService;
import com.example.science.util.exception.ErrorResponse;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/achievement-api")
public class AchievementController {
    @Autowired
    private AchievementService achievementService;
    @GetMapping("/get-all-achievement")
    public ResponseEntity<ErrorResponse> getAllAchievement()
    {
        List<Achievement>list=achievementService.getMyAchievementAndCount();
        return ErrorResponse.success(list);
    }

    @GetMapping("/get-quality-count")
    public ResponseEntity<ErrorResponse> getQualityCount()
    {
        List<Achievement>list=achievementService.getQualityCount();
        return ErrorResponse.success(list);
    }

    @PostMapping("/add-achievement")
    public String addAchievement(@RequestBody Achievement achievement)
    {
        achievementService.addAchievement(achievement);
        //System.out.println("新增成果数量+1");
        return "success!";
    }

    @GetMapping("get-achievement-status0")
    public ResponseEntity<ErrorResponse>getAchievementStatus0(@RequestParam(value = "id")Integer id)
    {
        List<Achievement>list=achievementService.getAchievementStatus0(id);
        return ErrorResponse.success(list);
    }

    @PostMapping("/update-achievement-status-q")
    public String updateAchievementStatus(@RequestParam(value = "id")Integer id,@RequestParam(value = "quality")Integer quality)
    {
        achievementService.updateAchievementStatus(id,quality);
        return "success!";
    }

    @PostMapping("/change-achievement-status")
    public String changeAchievementStatus(@RequestParam(value = "id")Integer id, @RequestParam(value = "status")Integer status)
    {
        achievementService.changeAchievementStatus(id,status);
        return "success!";
    }
}
