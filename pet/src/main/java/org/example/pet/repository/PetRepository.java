package org.example.pet.repository;


import org.example.pet.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Integer> {

//    @Query("SELECT p FROM Pet p WHERE p.species = :species")
    List<Pet> findBySpecies(String specices);
    List<Pet> findByAgeLessThan(int age);
    List<Pet> findByAgeGreaterThan(int age);
    List<Pet> findByGender(String gender);
//    @Query("SELECT p FROM Pet p WHERE p.shelter = :shelter")
    List<Pet> findByShelterId(Integer shelterId);

    //@Query(value = "SELECT * FROM pet p JOIN shelter s ON p.shelter_id = s.id WHERE s.location = :location", nativeQuery = true)
    //public List<pet> findByShelterLocation(@Param("location") String location);
//    @Query("SELECT p FROM Pet where p.id=:id")
    public boolean existsById(Integer id);

}
