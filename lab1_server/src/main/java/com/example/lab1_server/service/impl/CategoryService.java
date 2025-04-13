package com.example.lab1_server.service.impl;

import com.example.lab1_server.dto.category.CategoryRequest;
import com.example.lab1_server.dto.category.CategoryResponse;
import com.example.lab1_server.dto.category.CategorySearch;
import com.example.lab1_server.entity.Category;
import com.example.lab1_server.mapper.CategoryMapper;
import com.example.lab1_server.repository.ICategoryRepository;
import com.example.lab1_server.service.interfaces.ICategoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryService implements ICategoryService {
    ICategoryRepository categoryRepository;
    CategoryMapper categoryMapper;

    @Override
    public Page<CategoryResponse> findAll(CategorySearch categorySearch, Pageable pageable) {
        return categoryRepository.findAll(pageable).map(it -> categoryMapper.convertToResponse(it));
    }

    @Override
    public CategoryResponse create(CategoryRequest request) {
        var entity = categoryMapper.convertToEntity(request);
        return categoryMapper.convertToResponse(categoryRepository.save(entity));
    }

    @Override
    public CategoryResponse update(Long id, CategoryRequest request) {
        var entity = categoryRepository.findById(id).orElse(null);
        if(entity == null)
            return null;

        entity.setName(request.getName());
        return categoryMapper.convertToResponse(categoryRepository.save(entity));
    }

    @Override
    public boolean delete(long id) {
        var entity = categoryRepository.findById(id).orElse(null);
        if(entity != null) {
            entity.setIsDelete(true);
            categoryRepository.save(entity);
        }

        return true;
    }
}
