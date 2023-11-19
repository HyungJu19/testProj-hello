package com.testproj.controller;

import com.testproj.service.TourismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/tourism")
public class TourismController {
    private final TourismService tourismService;

    @Autowired
    public TourismController(TourismService tourismService) {
        this.tourismService = tourismService;
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword, @RequestParam int contentTypeId, Model model) {
        String info = tourismService.getTourismInfo(keyword, contentTypeId);
        model.addAttribute("info", info);
        return "tourism/searchResult"; // HTML 뷰 이름
    }
}
