package com.ysshin.demo.chat.dto;

import com.ysshin.demo.chat.entity.ChatRoom;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatRoomDto {

    private String roomName;

    @Builder
    public ChatRoomDto(String roomName) {
        this.roomName = roomName;
    }

}
