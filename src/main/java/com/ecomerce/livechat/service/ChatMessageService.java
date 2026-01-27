package com.ecomerce.livechat.service;

import com.ecomerce.livechat.dto.ChatMessageDTO;
import com.ecomerce.livechat.entity.ChatMessage;
import com.ecomerce.livechat.entity.ChatSession;
import com.ecomerce.livechat.repository.ChatMessageRepository;
import com.ecomerce.livechat.repository.ChatSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;
    private final ObjectMapper objectMapper;
    private final ChatSessionRepository chatSessionRepository;
    private final SimpMessagingTemplate messagingTemplate;


    public ChatMessageDTO saveMessage(ChatMessageDTO chatMessageDTO) {
        System.out.println(chatMessageDTO.sessionId());
        ChatSession chatSession = chatSessionRepository.findById(chatMessageDTO.sessionId()).orElseThrow(() -> new RuntimeException("Invalid session id"));
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setSession(chatSession);
        chatMessage.setContent(chatMessageDTO.content());
        chatMessage.setTimestamp(LocalDateTime.now());

        ChatMessage saved = chatMessageRepository.save(chatMessage);
        ChatMessageDTO response = objectMapper.convertValue(saved, ChatMessageDTO.class);
        messagingTemplate.convertAndSend("/topic/chats/" + chatMessageDTO.sessionId(), response);
        return response;

    }

    public List<ChatMessageDTO> receiveMessage(String sessionId){

        if (sessionId == null || sessionId.isEmpty()) {
            throw new RuntimeException("Session Id cannot be empty");
        }
            List<ChatMessage> messages = chatMessageRepository.findBySession_SessionId(sessionId);
            return messages.stream().map(message->new ChatMessageDTO(message.getId(),message.getSession().getSessionId(),message.getContent())).toList();
    }
}
