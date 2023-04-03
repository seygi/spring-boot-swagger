package com.example.springbootswagger.mapper;

import com.example.springbootswagger.dto.ChatroomDto;
import com.example.springbootswagger.model.Chatroom;

import java.util.*;

//@Mapper(componentModel = "spring")
//@Component
//public interface ChatroomMapper {
//    ChatroomMapper INSTANCE = Mappers.getMapper(ChatroomMapper.class);
//
//    @Mapping(target = "id", ignore = true)
//    Chatroom toEntity(ChatroomDto dto);
//
//    ChatroomDto toDto(Chatroom entity);
//
//    Collection<ChatroomDto> toDtos(Collection<Chatroom> entities);
//
//    Collection<Chatroom> toEntities(Collection<ChatroomDto> dtos);
//}

public class ChatroomMapper {

    public static Chatroom toEntity(ChatroomDto dto) {
        Chatroom entity = new Chatroom();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCreatedDate(dto.getCreatedDate());
        if (dto.getType() != null) {
            entity.setType(ChatroomTypeMapper.toEntity(dto.getType()));
        }
        return entity;
    }

    public static ChatroomDto toDto(Chatroom entity) {
        ChatroomDto dto = new ChatroomDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCreatedDate(entity.getCreatedDate());
        if (entity.getType() != null) {
            dto.setType(ChatroomTypeMapper.toDto(entity.getType()));
        }
        return dto;
    }

    public static List<ChatroomDto> toDtos(Collection<Chatroom> entities) {
        List<ChatroomDto> dtos = new ArrayList<>();
        if (!Objects.isNull(entities)) {
            for (Chatroom entity : entities) {
                dtos.add(toDto(entity));
            }
        }
        return dtos;
    }

    public static List<Chatroom> toEntities(Collection<ChatroomDto> dtos) {
        List<Chatroom> entities = new ArrayList<>();
        if (!Objects.isNull(dtos)) {
            for (ChatroomDto dto : dtos) {
                entities.add(toEntity(dto));
            }
        }
        return entities;
    }
}

