package com.example.springbootswagger.service;

import com.example.springbootswagger.model.Chatroom;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.util.Collection;

public interface ChatroomService {
    Chatroom findChatroomById(int id) throws DataAccessException;
    Page<Chatroom> findAllChatrooms(Pageable pageable) throws DataAccessException;
    Chatroom saveChatroom(Chatroom chatroom) throws DataAccessException;
    void deleteChatroom(Chatroom chatroom) throws DataAccessException;
}
