package com.example.springbootswagger.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class ChatroomMessageDto {
    @Setter
    @Getter
    protected Integer id;
    @Setter
    @Getter
    private LocalDateTime createdAt;

    @Setter
    @Getter
    private String message;

    @Setter
    @Getter
    private String createdUserName;

    @Setter
    @Getter
    private Integer chatroomId;
}