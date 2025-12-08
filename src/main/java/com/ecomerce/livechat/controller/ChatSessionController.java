package com.ecomerce.livechat.controller;

import com.ecomerce.livechat.dto.ChatSessionDTO;
import com.ecomerce.livechat.service.ChatSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("live_chat")
@RequestMapping("/api/liveChat")
public class ChatSessionController {
    private final ChatSessionService chatSessionService;

    @PostMapping()
    public ResponseEntity<ChatSessionDTO> createSession(@RequestParam String userId) {
        if (userId == null || userId.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        ChatSessionDTO dto = chatSessionService.createSession(userId);
        return ResponseEntity.ok(dto);
    }
}
