package com.ysshin.demo.web;

import com.ysshin.demo.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class WebController {

    private final ChatService chatService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/chats/room-list")
    public String chatRoomList() {
        return "/chat/room_list";
    }

    @GetMapping("/chats/create")
    public void createChats() {
        chatService.saveTestChatRooms();
    }

}
