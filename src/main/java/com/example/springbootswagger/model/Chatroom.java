package com.example.springbootswagger.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "chatrooms")
public class Chatroom extends NamedEntity {

    @Column(name = "created_date", columnDefinition = "DATETIME")
    @Setter
    @Getter
    @NotEmpty
    private LocalDateTime createdDate;

    @ManyToOne
    @JoinColumn(name = "type_id")
    @Setter
    @Getter
    @NotEmpty
    private ChatroomType type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chatroom", fetch = FetchType.EAGER)
    private Set<ChatroomMessage> messages;
    public Set<ChatroomMessage> getMessagesInternal() {
        if (this.messages == null) {
            this.messages = new HashSet<>();
        }
        return this.messages;
    }

    public void setMessagesInternal(Set<ChatroomMessage> messages) {
        this.messages = messages;
    }

    public void addMessage(ChatroomMessage message) {
        getMessagesInternal().add(message);
        message.setChatroom(this);
    }
}