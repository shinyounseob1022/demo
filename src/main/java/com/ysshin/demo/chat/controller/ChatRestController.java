package com.ysshin.demo.chat.controller;

import com.ysshin.demo.chat.dto.ChatRoomDto;
import com.ysshin.demo.chat.service.ChatService;
import com.ysshin.demo.common.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chats")
@RequiredArgsConstructor
public class ChatRestController {

    private final ChatService chatService;

    @PostMapping("/room")
    public ResponseDto createChatRoom(@RequestBody ChatRoomDto chatRoomDto) {
        return chatService.createChatRoom(chatRoomDto);
    }

    @GetMapping("/rooms")
    public ResponseDto getRoomList() {
        return chatService.getRoomList();
    }

}
