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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "chat_session_id", nullable = false,unique = true)
    private String id;
    private String userId;
    private LocalDateTime createdAt;
    private String status;
}
