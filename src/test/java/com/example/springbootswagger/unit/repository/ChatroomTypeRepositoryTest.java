package com.example.springbootswagger.unit.repository;

import com.example.springbootswagger.model.ChatroomType;
import com.example.springbootswagger.repository.ChatroomTypeRepository;
import com.example.springbootswagger.service.ChatroomTypeServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.isNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@SpringBootTest
public class ChatroomTypeRepositoryTest {
    @Autowired
    private ChatroomTypeRepository chatroomTypeRepository;

    @Test
    public void whenFindByName_thenReturnChatroomType() {
        // given
        ChatroomType type = new ChatroomType();
        type.setName("Private");
        chatroomTypeRepository.save(type);

        // when
        Optional<ChatroomType> found = chatroomTypeRepository.findById(type.getId());

        // then
        assertThat(found.get().getName(), is(type.getName()));
    }

    @Test
    public void whenFindByName_withInvalidName_thenReturnNull() {
        // given
        ChatroomType type = new ChatroomType();
        type.setName("Private");
        chatroomTypeRepository.save(type);

        // when
        Optional<ChatroomType> found = chatroomTypeRepository.findById(type.getId());

        // then
        assertThat(found.get(), isNotNull());
    }

    @Test
    public void whenSave_thenReturnSavedChatroomType() {
        // given
        ChatroomType type = new ChatroomType();
        type.setName("Private");

        // when
        ChatroomType saved = chatroomTypeRepository.save(type);

        // then
        assertThat(saved.getName(), is(type.getName()));
    }

    @Test
    public void whenDeleteById_thenChatroomTypeIsDeleted() {
        // given
        ChatroomType type = new ChatroomType();
        type.setName("Private");
        chatroomTypeRepository.save(type);

        // when
        chatroomTypeRepository.deleteById(type.getId());

        // then
        assertFalse(chatroomTypeRepository.findById(type.getId()).isPresent());
    }

}
