package com.co.istad.piseth.spring_web_mvc.dto;

import java.math.BigDecimal;

public record UpdateProductRequest(String name, BigDecimal price, String description) {
}
