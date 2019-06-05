package com.gyt.fittrainer.controllers;

import com.gyt.fittrainer.MyResult;
import com.gyt.fittrainer.dto.User;
import com.gyt.fittrainer.service.ITokenService;
import com.gyt.fittrainer.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * description
 *
 * @author guiyuting 2019/03/25 16:04
 */
@RequestMapping(value = "/user")
@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @ResponseBody
    @RequestMapping("/login")
    public MyResult login(@RequestBody User user,HttpServletRequest request){
        return  userService.login(user,request);
    }

    @ResponseBody
    @RequestMapping("/register")
    public MyResult register(@RequestBody User user,HttpServletRequest request){
        return  userService.register(user,request);
    }

    @ResponseBody
    @RequestMapping("/logout")
    public MyResult logout(@RequestBody User user,HttpServletRequest request){
        return  userService.login(user,request);
    }

}
