package com.ysshin.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {

    @GetMapping("/login")
    public String login() {
        return "/auth/login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "/member/signup";
    }

    @GetMapping("/room-list")
    public String chatList() {
        return "/chat/room_list";
    }

}
