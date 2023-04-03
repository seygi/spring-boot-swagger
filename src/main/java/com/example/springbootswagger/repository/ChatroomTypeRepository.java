package com.example.springbootswagger.repository;

import com.example.springbootswagger.model.ChatroomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatroomTypeRepository extends JpaRepository<ChatroomType, Integer> {
}
