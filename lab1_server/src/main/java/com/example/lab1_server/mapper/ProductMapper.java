package com.example.lab1_server.mapper;

import com.example.lab1_server.dto.product.ProductRequest;
import com.example.lab1_server.dto.product.ProductResponse;
import com.example.lab1_server.entity.Category;
import com.example.lab1_server.entity.Product;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductMapper {

    public ProductResponse convertToResponse(Product entity){
        return ProductResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .quantity(entity.getQuantity())
                .categoryId(entity.getCategory().getId())
                .categoryName(entity.getCategory().getName())

                .createDate(entity.getCreateDate())
                .updateDate(entity.getUpdateDate())
                .isDelete(entity.getIsDelete())
                .build();
    }

    public  Product convertToEntity(ProductRequest request){
        Category category = Category.builder()
                .id(request.getCategoryId())
                .build();

        return Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .category(category)
                .build();
    }
}
