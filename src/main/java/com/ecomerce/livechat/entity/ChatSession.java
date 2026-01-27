package com.ecomerce.livechat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="chat_session")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ChatSession {

    @Id
 //   @GeneratedValue(strategy = GenerationType.UUID)
    private String sessionId;
    private String userId;
    private LocalDateTime createdAt;
    private String status;

//    @OneToMany(mappedBy ="session", cascade = CascadeType.ALL)
//    private List<ChatMessage> messages;
}
