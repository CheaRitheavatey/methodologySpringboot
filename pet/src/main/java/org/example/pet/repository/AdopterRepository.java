package org.example.pet.repository;

import org.example.pet.model.Adopter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdopterRepository extends JpaRepository<Adopter, Integer> {
    List<Adopter> findByName(String name);
    List<Adopter> findByCity(String city);

}
