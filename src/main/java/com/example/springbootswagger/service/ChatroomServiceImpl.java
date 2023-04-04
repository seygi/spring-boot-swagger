package com.example.springbootswagger.service;

import com.example.springbootswagger.entity.Product;
import com.example.springbootswagger.model.Chatroom;
import com.example.springbootswagger.model.ChatroomType;
import com.example.springbootswagger.repository.ChatroomRepository;
import com.example.springbootswagger.repository.ChatroomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;

@Service
public class ChatroomServiceImpl implements ChatroomService {
    private ChatroomRepository chatroomRepository;
    private ChatroomTypeRepository chatroomTypeRepository;

    @Autowired
    public ChatroomServiceImpl(
            ChatroomRepository chatroomRepository,
            ChatroomTypeRepository chatroomTypeRepository) {
        this.chatroomRepository = chatroomRepository;
        this.chatroomTypeRepository = chatroomTypeRepository;

    }

    @Override
    @Transactional(readOnly = true)
    public Chatroom findChatroomById(int id) throws DataAccessException {

        Chatroom chatroom = null;
        try {
            chatroom = chatroomRepository.findById(id).get();
        } catch (ObjectRetrievalFailureException | EmptyResultDataAccessException e) {
            // just ignore not found exceptions for Jdbc/Jpa realization
            return null;
        }
        return chatroom;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Chatroom> findAllChatrooms(Pageable pageable) throws DataAccessException {
        return chatroomRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Chatroom saveChatroom(Chatroom chatroom) throws DataAccessException {
        if (chatroom.getType().getId() == 0) {
            ChatroomType chatroomType = new ChatroomType();
            chatroomType.setName(chatroom.getType().getName());
            var newChatroomType = chatroomTypeRepository.save(chatroomType);
            chatroom.setType(newChatroomType);
        }

        Chatroom newChatroom = chatroomRepository.save(chatroom);
        return newChatroom;
    }

    @Override
    public void deleteChatroom(Chatroom chatroom) throws DataAccessException {
        chatroomRepository.delete(chatroom);
    }
}
