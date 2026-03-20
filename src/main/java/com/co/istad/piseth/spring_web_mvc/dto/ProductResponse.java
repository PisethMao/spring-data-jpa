package com.co.istad.piseth.spring_web_mvc.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductResponse(Integer code,
                              String name,
                              BigDecimal price,
                              Integer quantity,
                              String description,
                              boolean isAvailable,
                              String categoryName) {
}
