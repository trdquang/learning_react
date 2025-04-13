package com.example.lab1_server.service.interfaces;

import com.example.lab1_server.dto.category.CategoryRequest;
import com.example.lab1_server.dto.category.CategoryResponse;
import com.example.lab1_server.dto.category.CategorySearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService {
    Page<CategoryResponse> findAll(CategorySearch categorySearch, Pageable pageable);
    CategoryResponse create(CategoryRequest request);
    CategoryResponse update(Long id, CategoryRequest request);
    boolean delete(long id);
}
