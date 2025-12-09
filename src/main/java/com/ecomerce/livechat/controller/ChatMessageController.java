package com.ecomerce.livechat.controller;

import com.ecomerce.livechat.dto.ChatMessageDTO;
import com.ecomerce.livechat.service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController("save-message")
@RequestMapping
public class ChatMessageController {
    private final ChatMessageService chatMessageService;

    @PostMapping("/save")
    public ResponseEntity<ChatMessageDTO> saveMessage(@RequestBody ChatMessageDTO chatMessageDTO){
      ChatMessageDTO dto=  chatMessageService.saveMessage(chatMessageDTO);
        return ResponseEntity.ok(dto);
    }
}
