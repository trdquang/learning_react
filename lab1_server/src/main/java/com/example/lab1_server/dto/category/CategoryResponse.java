package com.example.lab1_server.dto.category;

import com.example.lab1_server.dto.product.ProductResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryResponse {
    Long id;

    String name;
    private List<ProductResponse> productList;
}
