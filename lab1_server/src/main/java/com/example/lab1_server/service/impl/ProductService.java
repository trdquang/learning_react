package com.example.lab1_server.service.impl;

import com.example.lab1_server.dto.category.CategoryRequest;
import com.example.lab1_server.dto.category.CategoryResponse;
import com.example.lab1_server.dto.category.CategorySearch;
import com.example.lab1_server.dto.product.ProductRequest;
import com.example.lab1_server.dto.product.ProductResponse;
import com.example.lab1_server.dto.product.ProductSearch;
import com.example.lab1_server.entity.Category;
import com.example.lab1_server.mapper.CategoryMapper;
import com.example.lab1_server.mapper.ProductMapper;
import com.example.lab1_server.repository.ICategoryRepository;
import com.example.lab1_server.repository.IProductRepository;
import com.example.lab1_server.service.interfaces.IProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductService implements IProductService {
    IProductRepository productRepository;
    ProductMapper productMapper;

    @Override
    public Page<ProductResponse> findAll(ProductSearch productSearch, Pageable pageable) {
        return productRepository.findAll(pageable).map(it -> productMapper.convertToResponse(it));
    }

    @Override
    public ProductResponse create(ProductRequest request) {
        var entity = productMapper.convertToEntity(request);
        return productMapper.convertToResponse(productRepository.save(entity));
    }

    @Override
    public ProductResponse update(Long id, ProductRequest request) {
        var entity = productRepository.findById(id).orElse(null);
        if(entity == null)
            return null;
        Category category = Category.builder()
                .id(request.getCategoryId())
                .build();

        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setPrice(request.getPrice());
        entity.setQuantity(request.getQuantity());
        entity.setCategory(category);

        return productMapper.convertToResponse(productRepository.save(entity));
    }

    @Override
    public boolean delete(long id) {
        var entity = productRepository.findById(id).orElse(null);
        if(entity != null) {
            entity.setIsDelete(true);
            productRepository.save(entity);
        }

        return true;
    }
}
