package com.example.springbootswagger.repository;

import com.example.springbootswagger.model.ChatroomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatroomTypeRepository extends JpaRepository<ChatroomType, Integer> {
}
