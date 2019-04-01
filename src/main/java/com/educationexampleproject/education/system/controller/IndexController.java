package com.educationexampleproject.education.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "redirect:/index.do";
    }

    @RequestMapping("/index.do")
    public String toIndex() {
        return "index/index";
    }

}
