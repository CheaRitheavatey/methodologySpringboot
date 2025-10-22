package org.example.shopmethodology.service;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.shopmethodology.repository.ProductRepository;
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
