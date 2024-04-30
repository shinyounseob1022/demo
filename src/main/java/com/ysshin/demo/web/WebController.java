package com.ysshin.demo.web;

import com.ysshin.demo.chat.ChatRoom;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WebController {

    @GetMapping("/")
    public String indxe() {
        return "index";
    }

    @GetMapping("/chats")
    public String chats(Model model){
        return "chat/chat_list";
    }

}
