package com.example.science.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.science.entity.Achievement;
import com.example.science.mapper.AchievementMapper;
import com.example.science.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementServiceImpl extends ServiceImpl<AchievementMapper, Achievement> implements AchievementService {

    @Autowired
    private AchievementMapper achievementMapper;
    @Override
    //获取所有项目的成果类型以及数量（已通过）
    public List<Achievement> getMyAchievementAndCount() {
        List<Achievement> list=achievementMapper.getMyAchievementAndCount();
        return list;
    }

    @Override
    public List<Achievement> getQualityCount() {
        List<Achievement>list=achievementMapper.getQualityCount();
        return list;
    }

    @Override
    public void addAchievement(Achievement achievement) {
        achievementMapper.addAchievement(achievement);
    }

    @Override
    public List<Achievement> getAchievementStatus0(Integer id) {
        List<Achievement>list= achievementMapper.getAchievementStatus0(id);;
       return list;
    }

    @Override
    public void updateAchievementStatus(Integer id, Integer quality) {
        achievementMapper.updateAchievementStatus(id,quality);
    }

    @Override
    public void changeAchievementStatus(Integer id, Integer status) {
        achievementMapper.changeAchievementStatus(id,status);
    }
}
