package org.example.pet.repository;


import org.example.pet.model.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AdoptionRepository extends JpaRepository<Adoption, Long> {
    // count how many pet this adopter adopted
//    int countByAdopter_Id(Long adopterId);

    // find all adoption for speicifc adopter
//    List<Adoption> findByAdopterId(Long adopterId);

    // find all adoption for a specific pet
    List<Adoption> findByPetId(Integer petId);

    // find adoption by date
    List<Adoption> findByAdoptionDate(LocalDate adoptionDate);

    // find adoption before specific date
    List<Adoption> findByAdoptionDateBefore(LocalDate date);

}

