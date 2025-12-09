package com.ecomerce.livechat.service;

import com.ecomerce.livechat.dto.ChatMessageDTO;
import com.ecomerce.livechat.entity.ChatMessage;
import com.ecomerce.livechat.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class ChatMessageService {
    public final ChatMessageRepository chatMessageRepository;
    public final ObjectMapper objectMapper;

public ChatMessageDTO saveMessage(ChatMessageDTO chatMessageDTO){
try {
    ChatMessage chatMessage = objectMapper.convertValue(chatMessageDTO, ChatMessage.class);
    chatMessage.setId(chatMessage.getId());
    chatMessage.setSessionId(chatMessage.getSessionId());
    chatMessage.setSenderId(chatMessage.getSenderId());
    chatMessage.setContent(chatMessage.getContent());
    chatMessage.setTimestamp(LocalDateTime.now());

    chatMessageRepository.save(chatMessage);
    return objectMapper.convertValue(chatMessage, ChatMessageDTO.class);
} catch (Exception exception) {
    throw new RuntimeException("Failed to save message"+ exception.getMessage());
}
}

}
