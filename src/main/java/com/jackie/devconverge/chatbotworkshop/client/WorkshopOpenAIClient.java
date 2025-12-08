package com.jackie.devconverge.chatbotworkshop.client;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionCreateParams;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class WorkshopOpenAIClient {

    private final OpenAIClient client;
    private final String systemPrompt;

    public WorkshopOpenAIClient() {
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("OPENAI_API_KEY");

        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("OPENAI_API_KEY não encontrada no .env");
        }

        this.client = OpenAIOkHttpClient.builder()
                .apiKey(apiKey)
                .build();

        this.systemPrompt = loadSystemPrompt();
    }

    public String chat(String userMessage, String userId) {

        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .addSystemMessage(systemPrompt)
                .addUserMessage(buildUserMessage(userMessage, userId))
                .model(ChatModel.GPT_4O_MINI)
                .build();

        ChatCompletion completion = client.chat()
                .completions()
                .create(params);

        return completion.choices().stream()
                .flatMap(choice -> choice.message().content().stream())
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }

    private String buildUserMessage(String msg, String userId) {
        if (userId == null || userId.isBlank()) {
            return msg;
        }
        return "Usuário " + userId + " disse: " + msg;
    }

    private String loadSystemPrompt() {
        try (var input = getClass().getClassLoader().getResourceAsStream("prompts/system.txt")) {
            if (input == null) {
                throw new IllegalStateException("Arquivo system.txt não encontrado");
            }
            return new String(input.readAllBytes());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar system prompt", e);
        }
    }

}
