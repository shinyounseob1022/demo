package com.ysshin.demo.chat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.socket.WebSocketSession;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "CHAT_ROOM")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoom {

    @Id @GeneratedValue
    @Column(name = "CHAT_ROOM_ID")
    private Long id;

    @Column(name = "CHAT_ROOM_NAME")
    private String name;

    @Column(name = "WEBSOCKET_SESSION")
    private Set<WebSocketSession> sessions = new HashSet<>();

    @OneToMany(mappedBy = "chatRoom")
    List<ChatMessage> chatMessages = new ArrayList<>();

}
