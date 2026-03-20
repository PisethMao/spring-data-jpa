package com.co.istad.piseth.spring_web_mvc.service;

import com.co.istad.piseth.spring_web_mvc.domain.Category;
import com.co.istad.piseth.spring_web_mvc.domain.Product;
import com.co.istad.piseth.spring_web_mvc.dto.CreateProductRequest;
import com.co.istad.piseth.spring_web_mvc.dto.ProductResponse;
import com.co.istad.piseth.spring_web_mvc.mapper.ProductMapper;
import com.co.istad.piseth.spring_web_mvc.repository.CategoryRepository;
import com.co.istad.piseth.spring_web_mvc.repository.ProductRepository;
import com.co.istad.piseth.spring_web_mvc.util.GenerateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponse createProduct(CreateProductRequest request) {
        Category category = categoryRepository
                .findById(request.categoryId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
        Product product = new Product();
        product.setName(request.name());
        product.setPrice(request.price());
        product.setQuantity(request.quantity());
        product.setDescription(request.description());
        product.setCategory(category);
        product.setCode(GenerateUtil.generateUUID());
        product.setAvailable(true);
        product = productRepository.save(product);
        return productMapper.toProductResponse(product);
    }

    @Override
    public Page<ProductResponse> getProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository
                .findAll(pageable)
                .map(productMapper::toProductResponse);
    }
}
