package com.ysshin.demo.chat.entity;

import com.ysshin.demo.common.TimeStamp;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CHAT_MESSAGE")
@Getter
@NoArgsConstructor
public class ChatMessage extends TimeStamp {

    @Id @GeneratedValue
    @Column(name = "MESSAGE_ID")
    private Long id;

    @Column(name = "SENDER")
    private String sender;

    @Column(name = "MESSAGE")
    private String message;

    @ManyToOne
    @JoinColumn(name = "ROOM_ID")
    private ChatRoom chatRoom;

    @Builder
    public ChatMessage(String sender, String message, ChatRoom chatRoom) {
        this.sender = sender;
        this.message = message;
        this.chatRoom = chatRoom;
    }

}
