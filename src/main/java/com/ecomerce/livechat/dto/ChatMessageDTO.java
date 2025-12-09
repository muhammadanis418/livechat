package com.ecomerce.livechat.dto;

public record ChatMessageDTO(Long id, String sessionId, String senderId, String content) {
}
