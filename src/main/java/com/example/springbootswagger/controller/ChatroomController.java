package com.example.springbootswagger.controller;


import com.example.springbootswagger.dto.ChatroomDto;
import com.example.springbootswagger.dto.ChatroomMessageDto;
import com.example.springbootswagger.mapper.ChatroomMapper;
import com.example.springbootswagger.mapper.ChatroomMessageMapper;
import com.example.springbootswagger.service.ChatroomMessageService;
import com.example.springbootswagger.service.ChatroomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/chatroom")
public class ChatroomController {
    private final ChatroomService chatroomService;
    private final ChatroomMessageService chatroomMessageService;

    public ChatroomController(ChatroomService chatroomService, ChatroomMessageService chatroomMessageService) {
        this.chatroomService = chatroomService;
        this.chatroomMessageService = chatroomMessageService;
    }

    @GetMapping()
    public ResponseEntity<List<ChatroomDto>> listAllChatrooms() {
        List<ChatroomDto> chatrooms = new ArrayList<>(ChatroomMapper.toDtos(this.chatroomService.findAllChatrooms()));
        if (chatrooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(chatrooms, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ChatroomDto> saveProduct(@RequestBody ChatroomDto chatroomDto) {
        var chatroom = ChatroomMapper.toEntity(chatroomDto);
        var newChatroomDto = ChatroomMapper.toDto(chatroomService.saveChatroom(chatroom));
        return ResponseEntity.ok(newChatroomDto);
    }

    @PostMapping("{idChatRoom}/message")
    public ResponseEntity<ChatroomMessageDto> saveProduct(@PathVariable Integer idChatRoom, @RequestBody ChatroomMessageDto chatroomMessageDto) {
        chatroomMessageDto.setChatroomId(idChatRoom);
        var chatroomMessage = ChatroomMessageMapper.toEntity(chatroomMessageDto);
        var newChatroomMessageDto = ChatroomMessageMapper.toDto(chatroomMessageService.saveMessage(chatroomMessage));
        return ResponseEntity.ok(newChatroomMessageDto);
    }

    @GetMapping("{idChatRoom}/message")
    public ResponseEntity<List<ChatroomMessageDto>> listAllChatroomMessages(@PathVariable Integer idChatRoom) {
        var messages = chatroomMessageService.findChatroomMessagesByChatroomId(idChatRoom);
        var messagesDto = ChatroomMessageMapper.toDtos(messages);
        return ResponseEntity.ok(messagesDto);
    }
}
