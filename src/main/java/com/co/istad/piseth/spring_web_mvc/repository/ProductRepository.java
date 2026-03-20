package com.co.istad.piseth.spring_web_mvc.repository;

import com.co.istad.piseth.spring_web_mvc.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
