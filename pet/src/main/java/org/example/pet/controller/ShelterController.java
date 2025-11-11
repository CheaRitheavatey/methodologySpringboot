package org.example.pet.controller;


import org.example.pet.model.Shelter;
import org.example.pet.service.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 *
 * @author Dana
 */

@RestController
@RequestMapping("/shelters")
public class ShelterController {

    @Autowired
    private ShelterService service;

    @GetMapping
    public List<Shelter> getAllShelters() {
        return service.getAllShelters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shelter> getShelterById(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.getShelterById(id), HttpStatus.OK);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public Shelter createShelter(@RequestBody Shelter s) {
        return service.addShelter(s);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shelter> updateShelter(@PathVariable Integer id, @RequestBody Shelter s) {
        try {
            return new ResponseEntity<>(service.updateShelter(id, s), HttpStatus.OK);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShelter(@PathVariable Integer id) {
        service.deleteShelter(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search/{keyword}")
    public List<Shelter> searchShelters(@PathVariable String keyword) {
        return service.searchSheltersByName(keyword);
    }
}
