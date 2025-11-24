package com.example.science.controller;

import com.example.science.dto.UserProjectNumDto;
import com.example.science.entity.Project;
import com.example.science.entity.User;
import com.example.science.service.UserService;
import com.example.science.util.exception.BaseException;
import com.example.science.util.exception.ErrorCode;
import com.example.science.util.exception.ErrorResponse;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lsy
 * @since 2024-01-24
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //在post请求中采用@RequestParam注解那么前端需要使用new URLSearchParams()将参数以键值对的形式添加进请求中
    @PostMapping("/login")
    public ResponseEntity<ErrorResponse> login(@RequestParam(value = "username", required = false) String username,
                                               @RequestParam(value = "password", required = false) String password){
        System.out.println(username.getClass());
        System.out.println("controller："+ username+"    "+ password);
        Map<String,Object> res =  userService.login(username,password);
        return ErrorResponse.success(res);
    }

    @GetMapping("/info")
    public ResponseEntity<ErrorResponse> getInfo(@RequestParam(value = "username") String username) {
        //System.out.println("收到请求"+username);
        Map<String,Object> res =  userService.getInfo(username);
        System.out.println(res);
        return ErrorResponse.success(res);
    }

    //参与的
    @GetMapping("/get-people-projectNum")
    public ResponseEntity<ErrorResponse> getPeopleProjectNum()
    {
        List<UserProjectNumDto> list=userService.getUserInvolvedProjectNum();
        return ErrorResponse.success(list);
    }

    //负责的
    @GetMapping("/get-peopleCharge-projectNum")
    public ResponseEntity<ErrorResponse> getPeopleChargeProjectNum()
    {
        List<UserProjectNumDto> list=userService.getUserChargeProjectNum();
        return ErrorResponse.success(list);
    }
    @GetMapping("get-userCount")
    public ResponseEntity<ErrorResponse> getUserCount()
    {
        List<UserProjectNumDto>list=userService.getUserCount();
        return ErrorResponse.success(list);
    }

    @GetMapping("/get-user-data")
    public ResponseEntity<ErrorResponse> getUserData()
    {
        List<User>list =userService.getUserData();
        return  ErrorResponse.success(list);
    }

    @PostMapping("/add-user")
    public String addUser(@RequestBody User user)
    {
        userService.addUser(user);
        return "success!";
    }
    @GetMapping("/reset-user-password")
    public String resetUserPassword(@RequestParam(value = "id")String username)
    {
        //System.out.println(username);
        userService.resetPassword(username);
        return "success!";
    }

    @GetMapping("/delete-user")
    public String deleteUser(@RequestParam(value = "id")String username)
    {
        userService.deleteUser(username);
        return "success!";
    }

    @GetMapping("/get-project-user")
    public ResponseEntity<ErrorResponse> getProjectUser(@RequestParam(value = "projectid")Integer projectid)
    {
        List<User> list=userService.getProjectUser(projectid);
        return ErrorResponse.success(list);
    }

    @GetMapping("/get-myInfo")
    public ResponseEntity<ErrorResponse> getMyInfo(@RequestParam(value = "username") String username)
    {
        User user=userService.getMyInfo(username);
        return ErrorResponse.success(user);
    }

    @PostMapping("/update-myInfo")
    public ResponseEntity<ErrorResponse> updateMyInfo(@RequestBody User user)
    {
        userService.updateInfo(user);
        return ErrorResponse.success("success");
    }
}
