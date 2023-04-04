package com.example.springbootswagger.repository;


import com.example.springbootswagger.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM product ORDER BY id LIMIT ?2 OFFSET ?1", nativeQuery = true)
    List<Product> findAllWithPagination(int offset, int pageSize);
}