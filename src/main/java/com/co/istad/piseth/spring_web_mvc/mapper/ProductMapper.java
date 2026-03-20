package com.co.istad.piseth.spring_web_mvc.mapper;

import com.co.istad.piseth.spring_web_mvc.domain.Product;
import com.co.istad.piseth.spring_web_mvc.dto.ProductResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductResponse toProductResponse(Product product) {
        return ProductResponse.builder()
                .code(Integer.valueOf(product.getCode()))
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .description(product.getDescription())
                .isAvailable(product.isAvailable())
                .categoryName(product.getCategory().getName())
                .build();
    }
}
