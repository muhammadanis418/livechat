package com.ecomerce.livechat.controller;

import com.ecomerce.livechat.dto.ChatMessageDTO;
import com.ecomerce.livechat.service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController()
@RequestMapping
public class ChatMessageController {
    private final ChatMessageService chatMessageService;

    @PostMapping("/save")
    public ResponseEntity<ChatMessageDTO> saveMessage(@RequestBody ChatMessageDTO chatMessageDTO){
      ChatMessageDTO dto=  chatMessageService.saveMessage(chatMessageDTO);
        return ResponseEntity.ok(dto);
    }
    @GetMapping("/recieve")
    public ResponseEntity<List<ChatMessageDTO>>recieveMessage(@RequestParam String sessionId){
      List<ChatMessageDTO>messageDTOList=  chatMessageService.recieveMessage(sessionId);
        return ResponseEntity.ok(messageDTOList);
    }
}
