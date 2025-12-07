package com.jackie.devconverge.chatbotworkshop.controller;

import com.jackie.devconverge.chatbotworkshop.dto.ChatRequest;
import com.jackie.devconverge.chatbotworkshop.dto.ChatResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @PostMapping
    public ResponseEntity<ChatResponse> chat(@RequestBody ChatRequest request) {
        String fakeAnswer = "Recebi sua mensagem: " + request.getMessage();

        ChatResponse response = new ChatResponse(fakeAnswer);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
