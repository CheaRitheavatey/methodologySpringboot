package com.example.shop.service;

import com.example.shop.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;

    @PersistenceContext
    private EntityManager entityManager;


}
