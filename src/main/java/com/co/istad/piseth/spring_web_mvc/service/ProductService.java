package com.co.istad.piseth.spring_web_mvc.service;

import com.co.istad.piseth.spring_web_mvc.dto.CreateProductRequest;
import com.co.istad.piseth.spring_web_mvc.dto.ProductResponse;
import org.springframework.data.domain.Page;

public interface ProductService {
    ProductResponse createProduct(CreateProductRequest request);
    Page<ProductResponse> getProducts(int page, int size);
}
