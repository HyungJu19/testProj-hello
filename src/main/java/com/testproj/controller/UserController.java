package com.testproj.controller;

import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {



    @GetMapping("login")
    public void login(Model model){

    }

    @PostMapping("/login")
    public void loginprocess(){}



    // onAuthenticationFailure 에서 로그인 실패시 forwarding 용
    // request 에 담겨진 attribute 는 Thymeleaf 에서 그대로 표현 가능.
    @PostMapping("/loginError")
    public String loginError(){

        return "user/login";
    }


    @GetMapping("/signup")
    public void signup(){}

    @PostMapping("/signup")
    public String signupOk(){
        return null;
    }
}
