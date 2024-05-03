package com.ysshin.demo.chat.dto;

import com.ysshin.demo.chat.entity.ChatMessage;
import com.ysshin.demo.chat.entity.ChatRoom;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatMessageDto {

    private String sender;
    private String message;
    private ChatRoom chatRoom;

    @Builder
    public ChatMessageDto(String sender, String message, ChatRoom chatRoom) {
        this.sender = sender;
        this.message = message;
        this.chatRoom = chatRoom;
    }

}
