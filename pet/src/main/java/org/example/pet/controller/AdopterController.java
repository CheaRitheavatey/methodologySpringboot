package org.example.pet.controller;


import org.example.pet.model.Adopter;
import org.example.pet.service.AdopterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/adopter")
public class AdopterController {

    @Autowired
    private AdopterService service;

    @GetMapping
    public List<Adopter> getAllAdopters() {
        return service.getAllAdopters();
    }

    //get adopter by id
    @GetMapping(path = "/{id}")
    public ResponseEntity<Adopter> getAdopterById(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(service.getAdopterById(id));
    }

    //get adopter by name
    @GetMapping("/name/{name}")
    public List<Adopter> findByName(@PathVariable String name) {
        return service.findByName(name);
    }

    // get adopter by city
    @GetMapping("/city/{city}")
    public List<Adopter> findByCity(@PathVariable String city) {
        return service.findByCity(city);
    }

    //update adopter
    @PutMapping("/{id}")
    public ResponseEntity<Adopter> updateAdopter(@PathVariable Integer id, @RequestBody Adopter updatedAdopter) throws Exception {
        return ResponseEntity.ok(service.updateAdopter(id, updatedAdopter));
    }

    //post adopter
    @PostMapping("/addAdopter")
    public ResponseEntity<Adopter> addAdopter(@RequestBody Adopter adopter) {
        Adopter savedAdopter = service.addAdopter(adopter);
        return ResponseEntity.ok(savedAdopter);
    }

    //delete adopter
    @DeleteMapping("/{id}")
    public void deleteAdopter(@PathVariable Integer id) {
        service.deleteAdopter(id);
    }
}
