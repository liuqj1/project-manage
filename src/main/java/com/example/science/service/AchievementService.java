package com.example.science.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.science.entity.Achievement;

import java.util.List;

public interface AchievementService extends IService<Achievement> {

    //获取所有项目的成果类型以及数量(已通过)
    public List<Achievement> getMyAchievementAndCount();

    public List<Achievement> getQualityCount();
    public void addAchievement(Achievement achievement);

    public List<Achievement>getAchievementStatus0(Integer id);

    public void updateAchievementStatus(Integer id,Integer quality);

    public void changeAchievementStatus(Integer id,Integer status);
}
