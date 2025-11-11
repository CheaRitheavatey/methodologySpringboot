package org.example.pet.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import java.util.Date;

import org.example.pet.model.Shelter;
import org.example.pet.repository.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 *
 * @author Dana
 */
@Service
@Transactional
public class ShelterService {

    @Autowired
    private ShelterRepository repo;

    @PersistenceContext
    private EntityManager em;

    public List<Shelter> getAllShelters() {
        return repo.findAll();
    }

    public Shelter getShelterById(Integer id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Shelter not found"));
    }

    public Shelter addShelter(Shelter s) {
        return repo.save(s);
    }

    public Shelter updateShelter(Integer id, Shelter s) {
        Shelter existing = repo.findById(id).orElseThrow(() -> new RuntimeException("Shelter not found"));
        existing.setName(s.getName());
        existing.setLocation(s.getLocation());
        existing.setCapacity(s.getCapacity());
        existing.setPhone(s.getPhone());
        existing.setCreationday(s.getCreationday());
        return repo.save(existing);
    }

    public void deleteShelter(Integer id) {
        repo.deleteById(id);
    }

    public void addShelterSPQ(Shelter s) {
        StoredProcedureQuery spq = em.createStoredProcedureQuery("addShelter");
        spq.registerStoredProcedureParameter("nameIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("locationIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("capacityIN", Integer.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("phoneIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("creationdayIN", Date.class, ParameterMode.IN);

        spq.setParameter("nameIN", s.getName());
        spq.setParameter("locationIN", s.getLocation());
        spq.setParameter("capacityIN", s.getCapacity());
        spq.setParameter("phoneIN", s.getPhone());
        spq.setParameter("creationdayIN", s.getCreationday());

        spq.execute();
    }

    public void deleteShelterSPQ(Integer id) {
        StoredProcedureQuery spq = em.createStoredProcedureQuery("deleteShelter");
        spq.registerStoredProcedureParameter("idIN", Integer.class, ParameterMode.IN);
        spq.setParameter("idIN", id);
        spq.execute();
    }

    public List<Object[]> findOlderThanSPQ(java.util.Date date) {
        StoredProcedureQuery spq = em.createStoredProcedureQuery("findSheltersOlderThan");
        spq.registerStoredProcedureParameter("dateIN", java.util.Date.class, ParameterMode.IN);
        spq.setParameter("dateIN", date);
        return spq.getResultList();
    }

    public List<Object[]> findNewerThanSPQ(java.util.Date date) {
        StoredProcedureQuery spq = em.createStoredProcedureQuery("findSheltersNewerThan");
        spq.registerStoredProcedureParameter("dateIN", java.util.Date.class, ParameterMode.IN);
        spq.setParameter("dateIN", date);
        return spq.getResultList();
    }

    public List<Shelter> searchSheltersByName(String keyword) {
        return repo.findByNameContaining(keyword);
    }
}
