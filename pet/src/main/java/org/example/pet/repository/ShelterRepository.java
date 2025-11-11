package org.example.pet.repository;


import org.example.pet.model.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ShelterRepository extends JpaRepository<Shelter, Integer> {
//    List<Shelter> findByShelterNameContainingIgnoreCase(String keyword);
    List<Shelter> findByNameContainingIgnoreCase(String name);

    public List<Shelter> findByNameContaining(String keyword);
}
