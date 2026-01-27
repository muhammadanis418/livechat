package com.ecomerce.livechat.dto;

import java.time.LocalDateTime;

public record ChatSessionDTO(String sessionId, String userId, LocalDateTime createdAt, String status) {
}
