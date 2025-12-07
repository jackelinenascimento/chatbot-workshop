package com.jackie.devconverge.chatbotworkshop.dto;

import lombok.Getter;
import lombok.Setter;

public class ChatResponse {
    @Getter
    @Setter
    private String answer;

    public ChatResponse() {}

    public ChatResponse(String answer) {
        this.answer = answer;
    }
}
