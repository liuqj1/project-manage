package com.example.science;

import com.example.science.controller.ProjectController;
import com.example.science.entity.Expend;
import com.example.science.service.ExpendService;
import com.example.science.service.ProjectService;
import com.example.science.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ScienceApplicationTests {

    @Autowired
    ExpendService test;

    @Test
    void contextLoads() {

        Map<String,Object> map = new HashMap<>();
//        map.put("projectName",1);
        map.put("nickName","廖梓杰");
//        List<Expend> t=  test.search(map);
//        System.out.println(t);
//        test.getMyAllProjects("1");
    }



}
