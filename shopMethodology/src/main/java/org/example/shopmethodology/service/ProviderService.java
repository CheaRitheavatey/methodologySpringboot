package org.example.shopmethodology.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.shopmethodology.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class ProviderService {
    @Autowired
    private final ProviderRepository providerRepository;
    @PersistenceContext
    private EntityManager entityManager;
}
