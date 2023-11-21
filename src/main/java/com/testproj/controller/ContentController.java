package com.testproj.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/content")
public class ContentController {



    @GetMapping("/age_based_travel/detail")
    public void age_datail(){}

    @GetMapping("/age_based_travel/list")
    public void age_list(){}








    @GetMapping("family_travel/detail")
    public void family_detail(){}

    @GetMapping("family_travel/list")
    public void family_list(){}





    @GetMapping("festival_travel/detail")
    public void festival_detail(){}



    @GetMapping("festival_travel/list")
    public void festival_list(){}




    @GetMapping("foodie_travel/detail")
    public void foodie_detail(){}

    @GetMapping("foodie_travel/list")
    public void foodie_list(){}




}
