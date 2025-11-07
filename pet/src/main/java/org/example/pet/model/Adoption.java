package org.example.pet.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adoption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pet_id")
    private Pet pet;

//    @ManyToOne(optional = false)
//    @JoinColumn(name = "adopter_id")
//    private Adopter adopter;

    private LocalDate adoptionDate;
}
