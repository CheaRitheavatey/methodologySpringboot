package org.example.pet.controller;

import org.example.pet.model.Pet;
import org.example.pet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetController {

    @Autowired
    private PetService service;

    /* @GetMapping(value = "/pets/JPA")
     public List<pet> getAllPetsJPA() {
         return service.getAllPetsJPA();
     }

     @GetMapping(value = "/pet/JPA/{id}")
     public ResponseEntity<pet> getPetByIdJPA(@PathVariable Integer id) {
         try {
             pet Pet = (pet) service.getPetByIdJPA(id);
             return new ResponseEntity<>(Pet, HttpStatus.OK);
         } catch (NoSuchElementException ex) {
             return new ResponseEntity(HttpStatus.NOT_FOUND);
         }
     }

     @PostMapping(value = "/addPet/JPA")
     public void addPetJPA(@RequestBody pet p) {
         service.addPetJPA(p);
     }

     @DeleteMapping(value = "/deletePet/JPA/{id}")
     public void deletePetJPA(@PathVariable Integer id) {
         service.deletePetJPA(id);
     }

     @PutMapping(value = "/editPet/JPA/{id}")
     public ResponseEntity<pet> updatePetJPA(@RequestBody pet p, @PathVariable Integer id) {
         try {
             service.editPetJPA(id, p);
             return new ResponseEntity<>(HttpStatus.OK);
         } catch (NoSuchElementException ex) {
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
     }
 */
    // SPQ endpoints
    @GetMapping(value = "/getPets/SPQ")
    public List<Object[]> getPetsSPQ() {
        return service.getAllPetsSPQ();
    }

    @GetMapping(value = "/getPet/SPQ/{id}")
    public Object getPetByIdSPQ(@PathVariable Integer id) {
        return service.getPetByIdSPQ(id);
    }

    @PostMapping(value = "/addPet/SPQ")
    public void addPetSPQ(@RequestBody Pet p) {
        service.addPetSPQ(p);
    }

    @DeleteMapping(value = "/deletePet/SPQ/{id}")
    public void deletePetSPQ(@PathVariable Integer id) {
        service.deletePetSPQ(id);
    }

    @PutMapping(value = "/editPet/SPQ/{id}")
    public void editPetSPQ(@PathVariable Integer id, @RequestBody  Pet p) {
        service.updatePetSPQ(id, p);
    }

    // Extra endpoints
    @GetMapping(value = "/countPets")
    public Integer countPets() {
        return service.countPetsSPQ();
    }

    @GetMapping(value = "/findPetBySpecies/{species}")
    public List<Pet> findPetBySpecies(@PathVariable String species) {
        return service.findBySpecies(species);
    }

    //@GetMapping(value = "/findPetByShelterLocation/{location}")
    //public List<pet> findPetByShelterLocation(@PathVariable String location) {
    //  return service.findByShelterLocation(location);
    //}
}