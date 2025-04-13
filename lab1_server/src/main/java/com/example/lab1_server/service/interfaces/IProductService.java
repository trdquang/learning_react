package com.example.lab1_server.service.interfaces;

import com.example.lab1_server.dto.category.CategoryRequest;
import com.example.lab1_server.dto.category.CategoryResponse;
import com.example.lab1_server.dto.category.CategorySearch;
import com.example.lab1_server.dto.product.ProductRequest;
import com.example.lab1_server.dto.product.ProductResponse;
import com.example.lab1_server.dto.product.ProductSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<ProductResponse> findAll(ProductSearch productSearch, Pageable pageable);
    ProductResponse create(ProductRequest request);
    ProductResponse update(Long id, ProductRequest request);
    boolean delete(long id);
}
