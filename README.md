# ChatBot com Java, Spring Boot e OpenAI
Aplicação desenvolvida para o workshop “Do Zero ao ChatBot”, mostrando como integrar um backend Java com IA Generativa utilizando a SDK oficial da OpenAI.

---

## 🚀 Objetivo do Projeto
Criar um chatbot simples porém completo, com:

- API REST em Spring Boot
- DTOs usando records
- Service de orquestração
- Cliente OpenAI usando SDK oficial
- System prompt configurável por arquivo
- Suporte a diferentes usuários via userId

A proposta é demonstrar uma arquitetura limpa, moderna e fácil de entender.

---

## 📁 Estrutura do Projeto

```
src/
 └── main/
      ├── java/
      │    └── com.jackie.devconverge.chatbotworkshop/
      │          ├── controller/
      │          │     └── ChatController.java
      │          ├── service/
      │          │     └── ChatService.java
      │          ├── client/
      │          │     └── WorkshopOpenAIClient.java
      │          └── dto/
      │                ├── ChatRequest.java
      │                └── ChatResponse.java
      └── resources/
            └── prompts/
                   └── system.txt
```

---

## 🧩 Como funciona

### 1) O usuário envia uma requisição:
```
POST /api/chat
{
  "message": "Explique o workshop",
  "userId": "jackie"
}
```

### 2) O Controller recebe a requisição
Delegando para o service.

### 3) O Service processa
Chamando o client OpenAI.

### 4) O Client chama a OpenAI
Usando o SDK oficial e a API Key do `.env`.

### 5) O System Prompt define o comportamento da IA
Permitindo ajustes sem recompilar.

---

## 🏗️ Configurando o .env

Crie um arquivo `.env` na raiz do projeto:

```
OPENAI_API_KEY=sua-chave-aqui
```

Adicione ao `.gitignore`:

```
.env
```

---

## ▶️ Como rodar o projeto

### 1. Instale Java 17+
### 2. Rode o projeto:

```
./gradlew bootRun
```

O servidor inicia em:

```
http://localhost:8080
```

---

## 🧪 Testando a API

### Requisição:
```
POST http://localhost:8080/api/chat
Content-Type: application/json
```

### Body:
```json
{
  "message": "Me explique o que este projeto faz",
  "userId": "jackie"
}
```

### Resposta esperada:
```json
{
  "answer": "..."
}
```

---

## 🧠 System Prompt (resources/prompts/system.txt)

```
Você é um chatbot criado em Java e Spring Boot para demonstração em um workshop.
Responda com clareza, objetividade e em português do Brasil.
```

Altere esse arquivo para modificar o comportamento da IA sem recompilar.

---

## 🔌 Trecho do Client OpenAI

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
    .addSystemMessage(systemPrompt)
    .addUserMessage(message)
    .model(ChatModel.GPT_4O_MINI)
    .build();
```

---

## 📚 Tecnologias Utilizadas

- Java 17
- Spring Boot 4
- SDK Oficial OpenAI Java 4.x
- Gradle
- Records (Java moderno)
- dotenv para variáveis de ambiente

---

## 🧱 Próximos Passos (Evoluções sugeridas)

- Histórico de conversa por usuário
- Respostas em streaming
- Persistência de mensagens
- Interface web simples
- Integração com WhatsApp / Telegram
- Prompt engineering avançado

---

## ❤️ Créditos

Workshop desenvolvido por **Jackeline Nascimento**, com foco em capacitação de desenvolvedores e introdução prática à IA no backend.

---

## 📄 Licença

Este projeto é livre para uso educacional.