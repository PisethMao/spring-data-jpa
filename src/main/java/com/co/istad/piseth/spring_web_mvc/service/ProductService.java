package com.co.istad.piseth.spring_web_mvc.service;

import com.co.istad.piseth.spring_web_mvc.dto.CreateProductRequest;
import com.co.istad.piseth.spring_web_mvc.dto.PatchProductRequest;
import com.co.istad.piseth.spring_web_mvc.dto.ProductResponse;
import com.co.istad.piseth.spring_web_mvc.dto.UpdateProductRequest;
import org.springframework.data.domain.Page;

public interface ProductService {
    ProductResponse createProduct(CreateProductRequest request);
    Page<ProductResponse> getProducts(int page, int size);
    ProductResponse updateProduct(String code, UpdateProductRequest request);
    void deleteProduct(String code);
    ProductResponse getProductByCode(String code);
    ProductResponse patchProduct(String code, PatchProductRequest request);
}
