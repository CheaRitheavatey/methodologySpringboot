package org.example.shopmethodology.service;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.shopmethodology.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    @PersistenceContext
    private EntityManager entityManager;

}

