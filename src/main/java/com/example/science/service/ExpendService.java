package com.example.science.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.science.entity.Expend;

import java.util.List;
import java.util.Map;


public interface ExpendService extends IService<Expend> {
    public List<Expend> getProjectExpend(String projectId,String username);

    //增加报销记录
    public void insertExpend(Expend expend);

    public List<Expend>getMyUnverifiedExpend(String username);

    public void updateExpend(Integer id,Integer status);

    public List<Expend>search(Map<String,String> map);

    public Expend getExpendOverview();
}
