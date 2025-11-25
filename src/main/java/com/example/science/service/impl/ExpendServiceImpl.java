package com.example.science.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.science.entity.Expend;
import com.example.science.entity.Project;
import com.example.science.mapper.ExpendMapper;
import com.example.science.service.ExpendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ExpendServiceImpl extends ServiceImpl<ExpendMapper, Expend> implements ExpendService {
    @Autowired
    private ExpendMapper expendMapper;
    @Override
    public List<Expend> getProjectExpend(String projectId,String username) {
        List<Expend> list = new ArrayList<>();
//        QueryWrapper<Expend>wrapper=new QueryWrapper<>();
//        wrapper.eq("project_id",projectId);
//        list=expendMapper.selectList(wrapper);
//        for(Expend e:list)
//        {
//            System.out.println(e);
//        }
        list=expendMapper.getProjectExpend(projectId,username);
        return list;
    }

    @Override
    public void insertExpend(Expend expend) {
        expendMapper.insertExpend(expend);

    }

    @Override
    public List<Expend> getMyUnverifiedExpend(String username) {
        List<Expend> list=new ArrayList<>();
        list=expendMapper.getMyUnverifiedExpend(username);
//        for(Expend e:list)
//        {
//            System.out.println(e);
//        }
        return list;
    }

    @Override
    public void updateExpend(Integer id, Integer status) {
        expendMapper.updateExpend(id,status);
    }

    @Override
    public List<Expend> search(Map<String, String> map) {
        List<Expend> expendRecords =  expendMapper.search(map);
        return expendRecords;
    }

    @Override
    public Expend getExpendOverview() {
        Expend expend=expendMapper.getExpendOverview();
        return expend;
    }

}
