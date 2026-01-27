package com.ecomerce.livechat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "chat_message")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ChatMessage {
    @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "session_id",nullable = false)
    private ChatSession session;
  //  private String senderId; // user or support
   // @Column(length = 2000)
    private String content;
    private LocalDateTime timestamp= LocalDateTime.now();
}
