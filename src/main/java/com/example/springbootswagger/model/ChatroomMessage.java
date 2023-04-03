package com.example.springbootswagger.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "chatroommessages")
public class ChatroomMessage extends BaseEntity {

    @NotEmpty
    @Setter
    @Getter
    @Column(name = "created_at", columnDefinition = "DATETIME")
    private LocalDateTime createdAt;

    @NotEmpty
    @Setter
    @Getter
    @Column(name = "message")
    private String message;

    @NotEmpty
    @Setter
    @Getter
    @Column(name = "created_username")
    private String createdUserName;

    @ManyToOne
    @NotEmpty
    @Setter
    @Getter
    @JoinColumn(name = "chatroom_id")
    private Chatroom chatroom;


    /**
     * Creates a new instance of Visit for the current date
     */
    public ChatroomMessage() {
        this.createdAt = LocalDateTime.now();
    }
}