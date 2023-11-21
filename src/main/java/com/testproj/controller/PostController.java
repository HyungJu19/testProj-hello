package com.testproj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/board")
public class PostController {

    public PostController(){}

    @GetMapping("/board_write")
    public void write(){}

    @PostMapping("/board_write")
    public String writeOk(){
        return "redirect:/board/board_write";
    }

    @GetMapping("/board_list")
    public void list(){}

    @GetMapping("/board_update/{id}")
    public String update(){
        return "board/board_update";
    }


    @PostMapping("/board_update")
    public String updateOk(){
    return null;}


    @PostMapping("/board_delete")
    public String deleteOk(){
        return null;
    }



}