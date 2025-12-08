package com.ecomerce.livechat.dto;

import java.time.LocalDateTime;

public record ChatSessionDTO(String id, String userId, LocalDateTime createdAt, String status) {
}
