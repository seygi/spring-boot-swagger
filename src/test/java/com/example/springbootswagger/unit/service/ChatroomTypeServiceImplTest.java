package com.example.springbootswagger.unit.service;

import com.example.springbootswagger.model.ChatroomType;
import com.example.springbootswagger.repository.ChatroomTypeRepository;
import com.example.springbootswagger.service.ChatroomTypeService;
import com.example.springbootswagger.service.ChatroomTypeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ChatroomTypeServiceImplTest {

    @Mock
    private ChatroomTypeRepository chatroomTypeRepository;

    private ChatroomTypeService chatroomTypeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        chatroomTypeService = new ChatroomTypeServiceImpl(chatroomTypeRepository);
    }

    @Test
    public void testGetAllChatroomTypes() {
        // given
        var chatroomType1 = new ChatroomType();
        chatroomType1.setId(1);
        chatroomType1.setName("public");

        var chatroomType2 = new ChatroomType();
        chatroomType2.setId(2);
        chatroomType2.setName("private");

        List<ChatroomType> chatroomTypes = Arrays.asList(
                chatroomType1,
                chatroomType2
        );
        when(chatroomTypeRepository.findAll()).thenReturn(chatroomTypes);

        // when
        var result = chatroomTypeService.findAllChatroomTypes();

        // then
        assertEquals(chatroomTypes, result);
        verify(chatroomTypeRepository, times(1)).findAll();
    }

    @Test
    public void testGetChatroomTypeById() {
        // given
        var chatroomType = new ChatroomType();
        chatroomType.setId(1);
        chatroomType.setName("public");

        when(chatroomTypeRepository.findById(1)).thenReturn(Optional.of(chatroomType));

        // when
        ChatroomType result = chatroomTypeService.findChatroomTypeById(1);

        // then
        assertEquals(chatroomType, result);
        verify(chatroomTypeRepository, times(1)).findById(1);
    }

    @Test
    public void testSaveChatroomType() {
        // given
        var chatroomType = new ChatroomType();
        chatroomType.setName("public");


        var savedChatroomType = new ChatroomType();
        savedChatroomType.setId(1);
        savedChatroomType.setName("public");

        when(chatroomTypeRepository.save(any(ChatroomType.class))).thenReturn(savedChatroomType);

        // when
        ChatroomType result = chatroomTypeService.saveChatroomType(chatroomType);

        // then
        assertEquals(savedChatroomType, result);
        verify(chatroomTypeRepository, times(1)).save(chatroomType);
    }
}
