package org.example.shopmethodology.service;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.shopmethodology.exception.ResourceNotFoundException;
import org.example.shopmethodology.model.Order;
import org.example.shopmethodology.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public Order getOrderById(Long id) throws ResourceNotFoundException {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            return optionalOrder.get();
        } else {
            throw new ResourceNotFoundException("Order with id: " + id + " not found!!!");

        }

    }

}

