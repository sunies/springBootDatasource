package com.buegeon.controller;

import com.buegeon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    
    @Autowired
    private UserService userService;

    @RequestMapping("/getdb1")
    public String getRequestDBObj() {
        return userService.selectByPrimaryKey().toString();
    }
    
    @RequestMapping("/getdb2")
    public String getRequestDbList() {
        return userService.selectAllUser().toString();
    }
}