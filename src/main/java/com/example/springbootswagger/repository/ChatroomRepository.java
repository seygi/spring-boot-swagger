package com.example.springbootswagger.repository;

import com.example.springbootswagger.model.Chatroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatroomRepository extends JpaRepository<Chatroom, Integer> {
}
