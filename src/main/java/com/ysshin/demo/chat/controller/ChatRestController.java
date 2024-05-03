package com.ysshin.demo.chat.controller;

import com.ysshin.demo.chat.service.ChatService;
import com.ysshin.demo.common.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chats")
@RequiredArgsConstructor
public class ChatRestController {

    private final ChatService chatService;

    @GetMapping("/rooms")
    public ResponseDto getRoomList() {
        return chatService.getRoomList();
    }
}
