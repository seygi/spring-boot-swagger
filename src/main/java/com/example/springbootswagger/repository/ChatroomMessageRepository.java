package com.example.springbootswagger.repository;

import com.example.springbootswagger.model.ChatroomMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatroomMessageRepository extends JpaRepository<ChatroomMessage, Integer> {
//    List<ChatroomMessage> findByChatroomId(Integer chatroomId);
//
//    void delete(ChatroomMessage chatroomMessage) throws DataAccessException;
}
