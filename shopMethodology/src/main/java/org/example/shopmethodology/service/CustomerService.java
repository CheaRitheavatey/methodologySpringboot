package org.example.shopmethodology.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.shopmethodology.model.Customer;
import org.example.shopmethodology.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Transactional
@AllArgsConstructor
public class CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;

    @PersistenceContext
    private EntityManager entityManager;

//    public Customer addCustomer(Customer customer) {
//        return customerRepository.save(customer);
//    }

    public void addCustomer(Customer customer) {
        StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery("addCustomer");
        spq.registerStoredProcedureParameter("firstNameIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("lastNameIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("emailIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("addressIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("dobIN", Date.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("passwordIN", String.class, ParameterMode.IN);

        spq.setParameter("firstNameIN", customer.getFirstName());
        spq.setParameter("lastNameIN", customer.getLastName());
        spq.setParameter("emailIN", customer.getEmail());
        spq.setParameter("addressIN", customer.getAddress());
        spq.setParameter("dobIN", customer.getDateOfBirth());
    }

}
