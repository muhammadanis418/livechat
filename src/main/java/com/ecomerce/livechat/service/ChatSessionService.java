package com.ecomerce.livechat.service;

import com.ecomerce.livechat.dto.ChatSessionDTO;
import com.ecomerce.livechat.entity.ChatSession;
import com.ecomerce.livechat.repository.ChatSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChatSessionService {

    private final ChatSessionRepository chatSessionRepository;

    private final ObjectMapper objectMapper;

    public ChatSessionDTO createSession(String userId) {

        try {
            ChatSession chatSession = new ChatSession();
            chatSession.setUserId(UUID.randomUUID().toString());
            chatSession.setUserId(userId);
            chatSession.setCreatedAt(LocalDateTime.now());
            chatSession.setStatus("OPEN");
            chatSessionRepository.save(chatSession);
            return objectMapper.convertValue(chatSession, ChatSessionDTO.class);

        } catch (Exception exception) {
            throw new RuntimeException("Unable to create Session" + exception.getMessage());
        }


    }
}
