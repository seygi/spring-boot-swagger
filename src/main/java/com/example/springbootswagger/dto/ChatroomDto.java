package com.example.springbootswagger.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

public class ChatroomDto {

    @Setter
    @Getter
    protected Integer id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private LocalDateTime createdDate;

    @Getter
    @Setter
    private ChatroomTypeDto type;
}