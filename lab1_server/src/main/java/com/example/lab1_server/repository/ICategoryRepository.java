package com.example.lab1_server.repository;

import com.example.lab1_server.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
    @Query("""
            select ct from Category ct 
            order by ct.createDate           
            """)
    Page<Category> findAllBy(Pageable pageable);
}
