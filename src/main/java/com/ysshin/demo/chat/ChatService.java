package com.ysshin.demo.chat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ysshin.demo.web.ResponseDto;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;

    public ResponseDto createRoom(ChatRoomDto chatRoomDto) {

        ChatRoom chatRoom = ChatRoom.builder()
                .name(chatRoomDto.getName())
                .build();
        chatRepository.save(chatRoom);
        String message = "채팅방 생성 성공.";

        return ResponseDto.success(message, chatRoom);
    }

    public ResponseDto getAllChatRooms() {

        List<ChatRoom> chatRooms = chatRepository.findAll();
        String message = "채팅방 전체 조회 성공.";

        return ResponseDto.success(message, chatRooms);
    }

    public ResponseDto getChatRoom(Long roomId) {

        String message = "";
        ChatRoom chatRoom = chatRepository.findById(roomId).orElse(null);

        if (chatRoom == null) {
            message = "존재하지 않는 채팅방입니다.";
            return ResponseDto.fail(message);
        }

        message = "채팅방 조회 성공.";

        return ResponseDto.success(message, chatRoom);
    }

}