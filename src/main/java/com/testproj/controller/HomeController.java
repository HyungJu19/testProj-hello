package com.testproj.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping("/")
    public String hoem(){

        return "redirect:/home";
    }
    @Value("${google.maps.api.key}")
    private String googleMapsApiKey;

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("googleMapsApiKey", googleMapsApiKey);
        return "home";
    }
    //-------------------------------------------------------------------------
    // 현재 로그인한 정보 Authentication 보기 (디버깅 등 용도로 활용)

    @RequestMapping("/index")
    public void index(){}

}
