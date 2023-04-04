package com.example.springbootswagger.service;

import com.example.springbootswagger.model.ChatroomType;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

public interface ChatroomTypeService {
    ChatroomType findChatroomTypeById(int chatroomTypeId);
    Collection<ChatroomType> findAllChatroomTypes() throws DataAccessException;
    ChatroomType saveChatroomType(ChatroomType chatroomType) throws DataAccessException;
    void deleteChatroomType(ChatroomType chatroomType) throws DataAccessException;
}