package com.jackie.devconverge.chatbotworkshop.controller;

import com.jackie.devconverge.chatbotworkshop.dto.ChatRequest;
import com.jackie.devconverge.chatbotworkshop.dto.ChatResponse;
import com.jackie.devconverge.chatbotworkshop.service.ChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping
    public String hello() {
        return "Hello World!";
    }

    @PostMapping ("/chat")
    public ChatResponse chat(@RequestBody ChatRequest request) {
        String response = chatService.getAnswer(request.message(), request.userId());

        return new ChatResponse(response);
    }
}
