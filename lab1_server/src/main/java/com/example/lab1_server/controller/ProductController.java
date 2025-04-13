package com.example.lab1_server.controller;

import com.example.lab1_server.dto.category.CategoryRequest;
import com.example.lab1_server.dto.category.CategoryResponse;
import com.example.lab1_server.dto.product.ProductRequest;
import com.example.lab1_server.dto.product.ProductResponse;
import com.example.lab1_server.service.interfaces.ICategoryService;
import com.example.lab1_server.service.interfaces.IProductService;
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
@RequestMapping("/products")
public class ProductController {
    IProductService productService;

    @GetMapping("/list")
    public Page<ProductResponse> findAll(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                         @RequestParam(name = "limit", defaultValue = "75")Integer limit){
        Pageable pageable = PageRequest.of(page - 1, limit);
        return productService.findAll(null, pageable);
    }

    @PostMapping("/add")
    public ProductResponse creat(@RequestBody ProductRequest request) {
        return productService.create(request);
    }

    @PutMapping("/update/{id}")
    public ProductResponse update(@PathVariable Long id, @RequestBody ProductRequest request) {
        return productService.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return productService.delete(id);
    }
}
