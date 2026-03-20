package com.co.istad.piseth.spring_web_mvc.repository;

import com.co.istad.piseth.spring_web_mvc.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
