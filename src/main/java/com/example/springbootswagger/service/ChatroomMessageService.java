package com.example.springbootswagger.service;

import com.example.springbootswagger.model.ChatroomMessage;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

public interface ChatroomMessageService {

    Collection<ChatroomMessage> findChatroomMessagesByChatroomId(int chatroomId);
    ChatroomMessage findChatroomMessageById(int chatroomMessageId) throws DataAccessException;
    Collection<ChatroomMessage> findAllChatroomMessages() throws DataAccessException;
    ChatroomMessage saveMessage(ChatroomMessage chatroomMessage) throws DataAccessException;
    void deleteMessage(ChatroomMessage chatroomMessage) throws DataAccessException;
}
