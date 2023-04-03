package com.example.springbootswagger.mapper;

import com.example.springbootswagger.dto.ChatroomMessageDto;
import com.example.springbootswagger.model.Chatroom;
import com.example.springbootswagger.model.ChatroomMessage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

//@Mapper
//public interface ChatroomMessageMapper {
//    ChatroomMessageMapper INSTANCE = Mappers.getMapper(ChatroomMessageMapper.class);
//
//    @Mapping(target = "id", ignore = true)
//    ChatroomMessage toEntity(ChatroomMessageDto dto);
//
//    ChatroomMessageDto toDto(ChatroomMessage entity);
//
//    Collection<ChatroomMessageDto> toDtos(Collection<ChatroomMessage> entities);
//
//    Collection<ChatroomMessage> toEntities(Collection<ChatroomMessageDto> dtos);
//}


public class ChatroomMessageMapper {

    public static ChatroomMessage toEntity(ChatroomMessageDto dto) {
        ChatroomMessage entity = new ChatroomMessage();
        entity.setId(dto.getId());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setMessage(dto.getMessage());
        entity.setCreatedUserName(dto.getCreatedUserName());
        var chatroom = new Chatroom();
        chatroom.setId(dto.getChatroomId());
        entity.setChatroom(chatroom);
        return entity;
    }

    public static ChatroomMessageDto toDto(ChatroomMessage entity) {
        ChatroomMessageDto dto = new ChatroomMessageDto();
        dto.setId(entity.getId());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setMessage(entity.getMessage());
        dto.setCreatedUserName(entity.getCreatedUserName());
        dto.setChatroomId(entity.getChatroom().getId());
        return dto;
    }

    public static List<ChatroomMessageDto> toDtos(Collection<ChatroomMessage> entities) {
        List<ChatroomMessageDto> dtos = new ArrayList<>();
        if (!Objects.isNull(entities)) {
            for (ChatroomMessage entity : entities) {
                dtos.add(toDto(entity));
            }
        }
        return dtos;
    }

    public static List<ChatroomMessage> toEntities(Collection<ChatroomMessageDto> dtos) {
        List<ChatroomMessage> entities = new ArrayList<>();
        if (!Objects.isNull(dtos)) {
            for (ChatroomMessageDto dto : dtos) {
                entities.add(toEntity(dto));
            }
        }
        return entities;
    }
}