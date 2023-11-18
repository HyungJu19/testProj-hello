package com.testproj.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
public class TestController {

    @GetMapping("/list")
    public void list(){}


    @GetMapping("/asdf")
    public void datail(){}

    @GetMapping("/asdf")
    public void datail1(){}
    @GetMapping("/asdf")
    public void datail2(){}


    @GetMapping("/asdf")
    public void datail3(){}
}
