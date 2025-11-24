package com.example.science.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {


    @PostMapping("/login")
    public int login(){
        //System.out.println(2);
        return 1;
    }

}
