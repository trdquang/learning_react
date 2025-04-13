package com.example.lab1_server.controller;

import com.example.lab1_server.dto.category.CategoryRequest;
import com.example.lab1_server.dto.category.CategoryResponse;
import com.example.lab1_server.entity.Category;
import com.example.lab1_server.service.interfaces.ICategoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/categories")
public class CategoryController {
    ICategoryService categoryService;

    @GetMapping("/list")
    public Page<CategoryResponse> findAll(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                          @RequestParam(name = "limit", defaultValue = "75")Integer limit){
        Pageable pageable = PageRequest.of(page - 1, limit);
        return categoryService.findAll(null, pageable);
    }

    @PostMapping("/add")
    public CategoryResponse creat(@RequestBody CategoryRequest request) {
        return categoryService.create(request);
    }

    @PutMapping("/update/{id}")
    public CategoryResponse update(@PathVariable Long id, @RequestBody CategoryRequest request) {
        return categoryService.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return categoryService.delete(id);
    }
}
