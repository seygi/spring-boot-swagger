package com.example.springbootswagger.service;

import com.example.springbootswagger.model.ChatroomType;
import com.example.springbootswagger.repository.ChatroomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service

public class ChatroomTypeServiceImpl implements ChatroomTypeService {

    private ChatroomTypeRepository chatroomTypeRepository;

    @Autowired
    public ChatroomTypeServiceImpl(
            ChatroomTypeRepository chatroomTypeRepository) {
        this.chatroomTypeRepository = chatroomTypeRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public ChatroomType findChatroomTypeById(int chatroomTypeId) {

        ChatroomType chatroomType = null;
        try {
            chatroomType = chatroomTypeRepository.findById(chatroomTypeId).get();
        } catch (ObjectRetrievalFailureException | EmptyResultDataAccessException e) {
            // just ignore not found exceptions for Jdbc/Jpa realization
            return null;
        }
        return chatroomType;
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<ChatroomType> findAllChatroomTypes() throws DataAccessException {
        return chatroomTypeRepository.findAll();
    }

    @Override
    @Transactional
    public void savePetType(ChatroomType chatroomType) throws DataAccessException {
        chatroomTypeRepository.save(chatroomType);
    }

    @Override
    public void deletePetType(ChatroomType chatroomType) throws DataAccessException {
        chatroomTypeRepository.delete(chatroomType);
    }
}
