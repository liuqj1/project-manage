package com.example.science.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.science.entity.Expend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ExpendMapper extends BaseMapper<Expend> {
    public List<Expend> getProjectExpend(@Param("projectId")String projectId,@Param("username")String username);
    public List<Expend> getMyUnverifiedExpend(@Param("username") String username);

    public void insertExpend(@Param("expend") Expend expend);

    public void updateExpend(@Param("id")Integer id,@Param("status")Integer status);

    public List<Expend> search(Map<String, String> params);

    public Expend getExpendOverview();
}
