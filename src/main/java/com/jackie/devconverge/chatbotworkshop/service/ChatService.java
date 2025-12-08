package com.jackie.devconverge.chatbotworkshop.service;

import com.jackie.devconverge.chatbotworkshop.client.WorkshopOpenAIClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final WorkshopOpenAIClient openAIClient;

    public ChatService(WorkshopOpenAIClient openAIClient) {
        this.openAIClient = openAIClient;
    }

    public String getAnswer(String message, String userId) {
        return openAIClient.chat(message, userId);
    }
}
