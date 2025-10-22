package com.example.shop.service;

import com.example.shop.repository.OrderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class OrderService {
    @Autowired
    private final OrderRepository orderRepository;

    @PersistenceContext
    private EntityManager entityManager;

}
