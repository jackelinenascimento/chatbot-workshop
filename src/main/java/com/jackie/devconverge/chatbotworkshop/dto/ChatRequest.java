package com.jackie.devconverge.chatbotworkshop.dto;

import lombok.Getter;

public class ChatRequest {

    @Getter
    private String message;
    @Getter
    private String userId;

    public ChatRequest() {}

    public ChatRequest(String message, String userId) {
        this.message = message;
        this.userId = userId;
    }
}
