package com.example.lab1_server.dto.product;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {
    Long id;
    String name;
    String description;
    Double price;
    Integer quantity;


    Long categoryId;
    String categoryName;

    LocalDateTime createDate;
    LocalDateTime updateDate;
    Boolean isDelete;
}
