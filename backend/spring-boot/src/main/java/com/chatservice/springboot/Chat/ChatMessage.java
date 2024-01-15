package com.chatservice.springboot.Chat;

public class ChatMessage {

    private MessageType type;
    private String content;
    private String sender;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

    // Standard getters and setters
}