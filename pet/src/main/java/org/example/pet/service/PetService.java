package org.example.pet.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import org.example.pet.model.Pet;
import org.example.pet.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class PetService {

    @Autowired
    private PetRepository repo;

    @PersistenceContext
    private EntityManager em;

    // JPA
   /* public List<pet> getAllPetsJPA() {
        return repo.findAll();
    }

    public pet getPetByIdJPA(Integer id) {
        return repo.findById(id).orElseThrow(() -> new NoSuchElementException("Pet not found"));
    }

    public void addPetJPA(pet pet) {
        repo.save(pet);
    }

    public void deletePetJPA(Integer id) {
        repo.deleteById(id);
    }

    public void editPetJPA(Integer id, pet pet) {
        pet existing = repo.findById(id).orElseThrow(() -> new NoSuchElementException("Pet not found"));
        existing.setName(pet.getName());
        existing.setSpecies(pet.getSpecies());
        existing.setAge(pet.getAge());
        existing.setGender(pet.getGender());
        existing.setShelterId(pet.getShelterId());
        repo.save(existing);
    }
*/
    // Stored Procedure Query (SPQ)
    public List<Object[]> getAllPetsSPQ() {
        StoredProcedureQuery spq = em.createStoredProcedureQuery("getPets");
        return spq.getResultList();
    }

    public Object getPetByIdSPQ(Integer id) {
        StoredProcedureQuery spq = em.createStoredProcedureQuery("getPetById");
        spq.registerStoredProcedureParameter("idIN", Integer.class, ParameterMode.IN);
        spq.setParameter("idIN", id);
        return spq.getSingleResult();
    }

    public void addPetSPQ(Pet p) {
        StoredProcedureQuery spq = em.createStoredProcedureQuery("addPet");
        spq.registerStoredProcedureParameter("nameIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("speciesIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("ageIN", Integer.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("genderIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("shelterIdIN", Integer.class, ParameterMode.IN);

        spq.setParameter("nameIN", p.getName());
        spq.setParameter("speciesIN", p.getSpecies());
        spq.setParameter("ageIN", p.getAge());
        spq.setParameter("genderIN", p.getGender());
        spq.setParameter("shelterIdIN", p.getShelterId());
        spq.execute();
    }

    public void updatePetSPQ(Integer id, Pet p) {
        StoredProcedureQuery spq = em.createStoredProcedureQuery("updatePet");
        spq.registerStoredProcedureParameter("idIN", Integer.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("nameIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("speciesIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("ageIN", Integer.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("genderIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("shelterIdIN", Integer.class, ParameterMode.IN);

        spq.setParameter("idIN", id);
        spq.setParameter("nameIN", p.getName());
        spq.setParameter("speciesIN", p.getSpecies());
        spq.setParameter("ageIN", p.getAge());
        spq.setParameter("genderIN", p.getGender());
        spq.setParameter("shelterIdIN", p.getShelterId());
        spq.execute();
    }

    public void deletePetSPQ(Integer id) {
        StoredProcedureQuery spq = em.createStoredProcedureQuery("deletePet");
        spq.registerStoredProcedureParameter("idIN", Integer.class, ParameterMode.IN);
        spq.setParameter("idIN", id);
        spq.execute();
    }

    public Integer countPetsSPQ() {
        StoredProcedureQuery spq = em.createStoredProcedureQuery("countPets");
        spq.registerStoredProcedureParameter("petsCount", Integer.class, ParameterMode.OUT);
        spq.execute();
        return (Integer) spq.getOutputParameterValue("petsCount");
    }

    // JPA helper examples
    public List<Pet> findBySpecies(String species) {
        return repo.findBySpecies(species);
    }

//    public List<Pet> findByShelterLocation(String location) {
//      return repo.findByShelterId(location);
//    }
}