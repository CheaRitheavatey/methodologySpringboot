package org.example.pet.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.example.pet.exception.ResourceNotFoundException;
import org.example.pet.model.Adopter;
import org.example.pet.repository.AdopterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AdopterService {

    @Autowired
    private AdopterRepository repository;

    @PersistenceContext
    private EntityManager em;

    public List<Adopter> getAllAdopters() {
        return repository.findAll();
    }


    public Adopter getAdopterById(Integer id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Adopter not found"));
    }

    public List<Adopter> findByName(String name) {
        return repository.findByName(name);
    }

    public Adopter addAdopter(Adopter adopter) {
        StoredProcedureQuery spq = em.createStoredProcedureQuery("addAdopter");

        spq.registerStoredProcedureParameter("nameIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("emailIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("phoneIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("addressIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("cityIN", String.class, ParameterMode.IN);

        spq.setParameter("nameIN", adopter.getName());
        spq.setParameter("emailIN", adopter.getEmail());
        spq.setParameter("phoneIN", adopter.getPhone());
        spq.setParameter("addressIN", adopter.getAddress());
        spq.setParameter("cityIN", adopter.getCity());

        spq.execute();
        return adopter;
    }

    public void deleteAdopter(Integer id) {
        repository.deleteById(id);
    }

    public List<Adopter> findByCity(String city) {
        return repository.findByCity(city);
    }

    public Adopter updateAdopter(Integer id, Adopter updatedAdopter) {
        Adopter existing  = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Adopter not found"));
        existing.setName(updatedAdopter.getName());
        existing.setEmail(updatedAdopter.getEmail());
        existing.setPhone(updatedAdopter.getPhone());
        existing.setAddress(updatedAdopter.getAddress());
        existing.setCity(updatedAdopter.getCity());
        return repository.save(existing);
    }
}