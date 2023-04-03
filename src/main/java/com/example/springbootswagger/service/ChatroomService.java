package com.example.springbootswagger.service;

import com.example.springbootswagger.model.Chatroom;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

public interface ChatroomService {
    Chatroom findChatroomById(int id) throws DataAccessException;
    Collection<Chatroom> findAllChatrooms() throws DataAccessException;
    Chatroom saveChatroom(Chatroom chatroom) throws DataAccessException;
    void deleteChatroom(Chatroom chatroom) throws DataAccessException;
}
