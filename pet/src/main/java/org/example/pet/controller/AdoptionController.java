package org.example.pet.controller;

import lombok.AllArgsConstructor;
import org.example.pet.model.Adoption;
import org.example.pet.service.AdoptionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/adoption")
@AllArgsConstructor
public class AdoptionController {
    private final AdoptionService adoptionService;

    // GET all adoption
    @GetMapping
    public ResponseEntity<List<Adoption>> getAllAdoption() {
        return ResponseEntity.ok(adoptionService.getAllAdoption());
    }

    // GET adoption by id
    @GetMapping(path = "/{id}")
    public ResponseEntity<Adoption> getAdoptionById(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok(adoptionService.getAdoptionById(id));
    }
    // GET how many pet has adopted
//    @GetMapping(path = "/count/{adopterId}")
//    public ResponseEntity<Integer> getCountAdoptionByAdopter(@PathVariable Long adopterId) {
//        return ResponseEntity.ok(adoptionService.countAdoptionsByAdopter(adopterId));
//    }

    // GET all adoption that adopter made
//    @GetMapping(path = "/adopter/{id}")
//    public ResponseEntity<List<Adoption>> findByAdopterId(@PathVariable Long id) throws Exception {
//        return ResponseEntity.ok(adoptionService.findByAdopterId(id));
//    }

    // find all adoption that pet have gone through
    @GetMapping(path = "/pet/{id}")
    public ResponseEntity<List<Adoption>> findByPetId(@PathVariable Integer id) throws Exception{
        return ResponseEntity.ok(adoptionService.findByPetId(id));
    }

    // find adoption by date
    @GetMapping(path = "/date/{date}")
    public ResponseEntity<List<Adoption>> findByAdoptionDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(adoptionService.findByAdoptionDate(date));
    }

    // find adoption before specific date
    @GetMapping(path = "/before-date/{date}")
    public ResponseEntity<List<Adoption>> findByAdoptionDateBefore(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(adoptionService.findByAdoptionDateBefore(date));
    }

    // POST adoption
    @PostMapping
    public ResponseEntity<Adoption> addAdoption(@RequestBody Adoption adoption) throws Exception {
        return ResponseEntity.ok(adoptionService.addAdoption(adoption));
    }
    // DELETE adoption
    @DeleteMapping(path = "/{id}")
    public void deleteAdoption(@PathVariable Long id) throws Exception {
        adoptionService.deleteAdoption(id);

    }
}
