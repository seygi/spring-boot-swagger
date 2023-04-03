package com.example.springbootswagger.mapper;

import com.example.springbootswagger.dto.ChatroomTypeDto;
import com.example.springbootswagger.model.ChatroomType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

//@Mapper
//public interface ChatroomTypeMapper {
//    ChatroomTypeMapper INSTANCE = Mappers.getMapper(ChatroomTypeMapper.class);
//
//    @Mapping(target = "id", ignore = true)
//    ChatroomType toEntity(ChatroomTypeDto dto);
//
//    ChatroomTypeDto toDto(ChatroomType entity);
//
//    Collection<ChatroomTypeDto> toDtos(Collection<ChatroomType> entities);
//
//    Collection<ChatroomType> toEntities(Collection<ChatroomTypeDto> dtos);
//}


public class ChatroomTypeMapper {

    public static ChatroomType toEntity(ChatroomTypeDto dto) {
        ChatroomType entity = new ChatroomType();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    public static ChatroomTypeDto toDto(ChatroomType entity) {
        ChatroomTypeDto dto = new ChatroomTypeDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public static List<ChatroomTypeDto> toDtos(Collection<ChatroomType> entities) {
        List<ChatroomTypeDto> dtos = new ArrayList<>();
        if (!Objects.isNull(entities)) {
            for (ChatroomType entity : entities) {
                dtos.add(toDto(entity));
            }
        }
        return dtos;
    }

    public static List<ChatroomType> toEntities(Collection<ChatroomTypeDto> dtos) {
        List<ChatroomType> entities = new ArrayList<>();
        if (!Objects.isNull(dtos)) {
            for (ChatroomTypeDto dto : dtos) {
                entities.add(toEntity(dto));
            }
        }
        return entities;
    }
}