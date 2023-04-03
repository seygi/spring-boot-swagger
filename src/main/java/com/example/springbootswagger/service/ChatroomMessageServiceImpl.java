package com.example.springbootswagger.service;

import com.example.springbootswagger.model.ChatroomMessage;
import com.example.springbootswagger.repository.ChatroomMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ChatroomMessageServiceImpl implements ChatroomMessageService {
    private ChatroomMessageRepository chatroomMessageRepository;

    @Autowired
    public ChatroomMessageServiceImpl(
            ChatroomMessageRepository chatroomMessageRepository) {
        this.chatroomMessageRepository = chatroomMessageRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<ChatroomMessage> findChatroomMessagesByChatroomId(int chatroomId) {
        return chatroomMessageRepository.findAll()
                .stream().filter(x ->
                        x.getChatroom().getId() == chatroomId
                ).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)

    public ChatroomMessage findChatroomMessageById(int chatroomMessageId) throws DataAccessException {

        ChatroomMessage chatroomMessage = null;
        try {
            chatroomMessage = chatroomMessageRepository.findById(chatroomMessageId).get();
        } catch (ObjectRetrievalFailureException | EmptyResultDataAccessException e) {
            // just ignore not found exceptions for Jdbc/Jpa realization
            return null;
        }
        return chatroomMessage;
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<ChatroomMessage> findAllChatroomMessages() throws DataAccessException {
        return chatroomMessageRepository.findAll();
    }

    @Override
    @Transactional
    public ChatroomMessage saveMessage(ChatroomMessage chatroomMessage) throws DataAccessException {
       return chatroomMessageRepository.save(chatroomMessage);
    }

    @Override
    @Transactional
    public void deleteMessage(ChatroomMessage chatroomMessage) throws DataAccessException {
        chatroomMessageRepository.delete(chatroomMessage);
    }
}
