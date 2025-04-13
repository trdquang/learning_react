package com.example.lab1_server.mapper;

import com.example.lab1_server.dto.category.CategoryRequest;
import com.example.lab1_server.dto.category.CategoryResponse;
import com.example.lab1_server.dto.product.ProductResponse;
import com.example.lab1_server.entity.Category;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryMapper {
    ProductMapper productMapper;

    public CategoryResponse convertToResponse(Category entity){
        List<ProductResponse> productResponseList = new ArrayList<>();
        if(entity.getProductList() != null){
            for (var it: entity.getProductList())
                productResponseList.add(productMapper.convertToResponse(it));
        }

        return CategoryResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .productList(productResponseList)
                .build();
    }

    public Category convertToEntity(CategoryRequest request){
        return Category.builder()
                .name(request.getName())
                .build();
    }
}
