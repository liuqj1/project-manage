package com.example.science.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.science.entity.Achievement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AchievementMapper extends BaseMapper<Achievement> {
    //获取所有项目的成果类型以及数量（已通过）
    public List<Achievement> getMyAchievementAndCount();

    public List<Achievement> getQualityCount();

    public void addAchievement(Achievement achievement);

    public List<Achievement> getAchievementStatus0(@Param("id")Integer id);

    public void updateAchievementStatus(@Param("id")Integer id,@Param("quality")Integer quality);

    public void changeAchievementStatus(@Param("id")Integer id,@Param("status")Integer status);
}
