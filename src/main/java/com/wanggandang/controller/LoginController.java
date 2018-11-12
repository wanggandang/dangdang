package com.wanggandang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/manager")
    public String managerCotroller(){
        return "/search";
    }
    @GetMapping("/login")
    public String loginCotroller(){
        return "/subject";
    }
}
