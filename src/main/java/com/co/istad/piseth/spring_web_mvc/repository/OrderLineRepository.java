package com.co.istad.piseth.spring_web_mvc.repository;

import com.co.istad.piseth.spring_web_mvc.domain.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderLineRepository extends JpaRepository<OrderLine, UUID> {
}
