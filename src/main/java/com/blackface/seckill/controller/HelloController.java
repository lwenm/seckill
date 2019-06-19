package com.blackface.seckill.controller;

import com.blackface.seckill.domain.SecUser;
import com.blackface.seckill.result.Result;
import com.blackface.seckill.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author:lwenm
 * Description: hello 控制器
 * Date:2019/5/8
 * Time:22:00
 **/

@Controller
@RequestMapping("/fortest")
public class HelloController {


    @Autowired
    UserServiceImpl userService;

    /**
     * hello
     * @param model
     * @return
     */
    @GetMapping("/hello")
    public String thymeleaf(Model model){

        model.addAttribute("name","qwerty");
        return "hello";
    }


    /**
     *
     * @return
     */
    @GetMapping("/db/user")
    @ResponseBody
    public Result<SecUser> getUser(){

        SecUser userMaster = userService.getUserById(1L);
        return Result.success(userMaster);
    }

}
