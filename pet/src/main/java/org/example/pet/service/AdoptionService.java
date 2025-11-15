package org.example.pet.service;

import lombok.AllArgsConstructor;
import org.example.pet.exception.PetAlreadyAdoptException;
import org.example.pet.exception.ResourceNotFoundException;
import org.example.pet.model.Adoption;
import org.example.pet.model.Pet;
import org.example.pet.repository.AdoptionRepository;
import org.example.pet.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class AdoptionService {
    private AdoptionRepository adoptionRepository;
    private PetRepository petRepository;
//    private AdopterRepository adopterRepository;

    // get all adoption
    public List<Adoption> getAllAdoption() {
        return adoptionRepository.findAll();
    }
    // get adoption by id
    public Adoption getAdoptionById(Long id) throws Exception {
        return adoptionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("adoption with id: " + id + " not found"));
    }
    // add adoption
    public Adoption addAdoption(Adoption adoption) throws Exception {
        Pet pet = petRepository.findById(adoption.getPet().getId()).orElseThrow(() -> new ResourceNotFoundException("pet id: " + adoption.getPet().getId() + " not found"));

        // check if the pet avaiable to adopt
        if (pet.isAdopted()) {
            throw new PetAlreadyAdoptException("pet id " + pet.getId() + " name " + pet.getName() + " already adopted" );
        }

        // set the pet as adopted
        pet.setAdopted(true);
        petRepository.save(pet);

        // set date of adoption
        if (adoption.getAdoptionDate() == null) {
            adoption.setAdoptionDate(LocalDate.now());
        }

        return adoptionRepository.save(adoption);
    }
    // delete adoption
    public void deleteAdoption(Long id) throws Exception {
        // mark pet as availbale again
        Adoption adoption = getAdoptionById(id);
        Pet pet = adoption.getPet();
        pet.setAdopted(false);
        petRepository.save(pet);

        adoptionRepository.deleteById(id);
    }
    // count how many pet the adopter has
//    public int countAdoptionsByAdopter(Long id) {
//        return adoptionRepository.countByAdopter_Id(id);
//    }

    // find all adoption for speicifc adopter
//    public List<Adoption> findByAdopterId(Long adopterId) throws Exception {
//        if (!adopterRepository.existsById(adopterId)) {
//            throw new IllegalArgumentException("adopter with id: " + adopterId + " not found");
//        }
//
//        return adoptionRepository.findByAdopterId(adopterId);
//    }

    // find all adoption for a specific pet
    public List<Adoption> findByPetId(Integer petId) throws Exception {
        if (!petRepository.existsById(petId)) {
            throw new ResourceNotFoundException("pet with id: " + petId + "not found");
        }
        return adoptionRepository.findByPetId(petId);
    }

    // find adoption by date
    public List<Adoption> findByAdoptionDate(LocalDate adoptionDate) {
        if (adoptionDate == null) {
            throw new ResourceNotFoundException("Adoption date cannot be null");
        }

        return adoptionRepository.findByAdoptionDate(adoptionDate);
    }

    // find adoption before specific date
    public List<Adoption> findByAdoptionDateBefore(LocalDate date) {
        return adoptionRepository.findByAdoptionDateBefore(date);
    }


}

