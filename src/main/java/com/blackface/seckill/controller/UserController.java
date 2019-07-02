package com.blackface.seckill.controller;

import com.blackface.seckill.domain.SecUser;
import com.blackface.seckill.result.CodeMsg;
import com.blackface.seckill.result.Result;
import com.blackface.seckill.util.ValidatorUtil;
import com.blackface.seckill.service.impl.UserServiceImpl;
import com.blackface.seckill.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Author:lwenm
 * Description: 用户控制类
 * Date:2019/5/13
 * Time:22:58
 **/
@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserServiceImpl userService;

    @PostMapping("/do_login")
    @ResponseBody
    public Result<Object> login(HttpServletResponse response, @Valid LoginVo loginVo){

        String password = loginVo.getPassword();
        String mobile = loginVo.getMobile();
        if(StringUtils.isEmpty(mobile)){
            return Result.error(CodeMsg.MOBILE_EMPTY);
        }
        if(!ValidatorUtil.isMobile(mobile)){

            return Result.error(CodeMsg.MOBILE_ERROR);
        }
        if(StringUtils.isEmpty(password)){
            return Result.error(CodeMsg.PASSWORD_ERROR);
        }
        CodeMsg codeMsg = userService.login(response,loginVo);
        if(codeMsg.getCode() ==0){
            return  Result.success(true);
        }else {
            return Result.error(codeMsg);
        }
    }


    @RequestMapping("/to_login")
    public String toLogin() {
        return "login";
    }



    @RequestMapping("/info")
    @ResponseBody
    public Result<SecUser> info(Model model, SecUser user){

        model.addAttribute("user",user);
        return Result.success(user);

    }

}
