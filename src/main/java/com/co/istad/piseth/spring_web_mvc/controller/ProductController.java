package com.co.istad.piseth.spring_web_mvc.controller;

import com.co.istad.piseth.spring_web_mvc.dto.CreateProductRequest;
import com.co.istad.piseth.spring_web_mvc.dto.ProductResponse;
import com.co.istad.piseth.spring_web_mvc.dto.UpdateProductRequest;
import com.co.istad.piseth.spring_web_mvc.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{code}")
    public ProductResponse getProductByCode(@PathVariable Integer code) {
        log.info("Getting product with code: {}", code);
        return null;
    }

    @GetMapping
    public Page<ProductResponse> getProducts(
            @RequestParam(required = false, defaultValue = "0") int pageNumber,
            @RequestParam(required = false, defaultValue = "25") int pageSize
    ) {
        return productService.getProducts(pageNumber, pageSize);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ProductResponse createNew(@Valid @RequestBody CreateProductRequest createProductRequest) {
        log.info("Creating new product: {}", createProductRequest);
        return productService.createProduct(createProductRequest);
    }

    @PutMapping("/{code}")
    public ProductResponse updateByCode(@PathVariable Integer code,
                                        @RequestBody UpdateProductRequest updateProductRequest) {
        log.info("Updating product with code: {} with {}", code, updateProductRequest);
        return null;
    }

    @PatchMapping("/{code}")
    public ProductResponse patchByCode(@PathVariable Integer code,
                                       @RequestBody UpdateProductRequest updateProductRequest) {
        log.info("Patching product with code: {} with {}", code, updateProductRequest);
        return null;
    }

    @DeleteMapping("/{code}")
    public void deleteByCode(@PathVariable Integer code) {
        log.info("Deleting product with code: {}", code);
    }
}
