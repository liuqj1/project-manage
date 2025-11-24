package com.example.science.controller;

import com.example.science.entity.Expend;
import com.example.science.service.ExpendService;
import com.example.science.util.exception.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/expend-api")
public class ExpendController {
    @Autowired
    private ExpendService expendService;

    @GetMapping("/get-myProject-expend")
    public ResponseEntity<ErrorResponse>getMyProjectExpend(@RequestParam(value = "projectId") String projectId,
                                                           @RequestParam(value = "username")String username)
    {
        //System.out.println("收到的参数："+projectId);
        List<Expend>list=expendService.getProjectExpend(projectId,username);
        return ErrorResponse.success(list);
    }
    @PostMapping("/submit-reimbursement")
    public String addReimbursementRecord(@RequestBody Expend expend)
    {
        expendService.insertExpend(expend);
        return "success!";
    }

    @GetMapping("/get-myUnverified-expend")
    public  ResponseEntity<ErrorResponse>getMyUnverifiedExpend(@RequestParam(value = "username")String username)
    {
        //System.out.println(username);
        List<Expend>list=expendService.getMyUnverifiedExpend(username);
        return ErrorResponse.success(list);
    }

    @PostMapping("/verify-expend")
    public String verifyExpend(@RequestParam(value = "id")Integer id,@RequestParam(value = "status")Integer status)
    {
        //System.out.println(id+" "+status);
        expendService.updateExpend(id,status);
        return "success!";
    }

    @PostMapping("/search")
    public ResponseEntity<ErrorResponse> search(@RequestBody Map<String,String> map)
    {
        //System.out.println("收到请求");

        for (String key : map.keySet()) {

            Object value = map.get(key);
            //System.out.println(value);

        }
        List<Expend> list = expendService.search(map);
        return ErrorResponse.success(list);
    }



    @GetMapping("/get-expend-overview")
    public ResponseEntity<ErrorResponse> fetchExpendOverview()
    {
        Expend expend=expendService.getExpendOverview();
        return   ErrorResponse.success(expend);
    }
}
