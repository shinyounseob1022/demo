package com.ysshin.demo.chat.service;

import com.ysshin.demo.chat.entity.ChatMessage;
import com.ysshin.demo.chat.entity.ChatRoom;
import com.ysshin.demo.chat.repository.ChatMessageRepository;
import com.ysshin.demo.chat.repository.ChatRoomRepository;
import com.ysshin.demo.common.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRoomRepository chatRoomRepository;
    private final ChatMessageRepository chatMessageRepository;

    public void saveTestChatRooms() {
        ChatRoom chatRoom1 = ChatRoom.builder()
                .roomName("chatRoom1")
                .build();
        ChatRoom chatRoom2 = ChatRoom.builder()
                .roomName("chatRoom2")
                .build();
        ChatRoom chatRoom3 = ChatRoom.builder()
                .roomName("chatRoom3")
                .build();
        chatRoomRepository.save(chatRoom1);
        chatRoomRepository.save(chatRoom2);
        chatRoomRepository.save(chatRoom3);
    }

    public ChatMessage saveChatMessage(Long roomId, String sender, String message) {

        ChatRoom chatRoom = chatRoomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 채팅방 아이디입니다."));

        ChatMessage chatMessage = ChatMessage.builder()
                .chatRoom(chatRoom)
                .sender(sender)
                .message(message)
                .build();
        chatMessageRepository.save(chatMessage);

        return chatMessage;
    }

    public ResponseDto getRoomList() {
        List<ChatRoom> chatRoomList = chatRoomRepository.findAll();
        String message = "채팅방 전체 조회 성공.";
        return ResponseDto.success(message, chatRoomList);
    }
}
