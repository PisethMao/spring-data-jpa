package com.co.istad.piseth.spring_web_mvc.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;

import java.math.BigDecimal;

public record PatchProductRequest(
        String name,
        @DecimalMin(value = "0.01", inclusive = false, message = "Price must be greater than 0")
        BigDecimal price,
        @Min(value = 0, message = "Quantity must be greater than or equal to 0")
        Integer quantity,
        String description,
        Integer categoryId
) {
}
