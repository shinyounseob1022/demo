package com.ysshin.demo.chat;

import com.ysshin.demo.web.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/chats")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    // 채팅방 생성
    @PostMapping("/create-room")
    public ResponseDto createRoom(@RequestBody ChatRoomDto chatRoomDto) {
        return chatService.createRoom(chatRoomDto);
    }

    // 채팅방 전체 조회
    @GetMapping()
    public ResponseDto getAllChatRooms(){
        return chatService.getAllChatRooms();
    }

    // 채팅방 조회
    @GetMapping("/{id}")
    public ResponseDto getChatRoom(@PathVariable Long id){
        return chatService.getChatRoom(id);
    }


}
