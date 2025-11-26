package org.example.pet.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@Table(name = "pet")
//@AllArgsConstructor
//@NamedQueries({
//        @NamedQuery(name = "pet.findAll", query = "SELECT p FROM pet p"),
//        @NamedQuery(name = "pet.findById", query = "SELECT p FROM pet p WHERE p.id = :id"),
//        @NamedQuery(name = "pet.findBySpecies", query = "SELECT p FROM pet p WHERE p.species = :species")
//})
public class Pet implements Serializable {


//    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String species;
    private Integer age;
    private String gender;
    private boolean adopted;

    @Column(name = "shelter_id")
    private Integer shelterId;

    public Pet() {
    }

    public Pet(Integer id) {
        this.id = id;
    }

    public Pet(String name, String species, Integer age, String gender, Integer shelterId,boolean adoped) {
          this.name = name;
        this.species = species;
      this.age = age;
     this.gender = gender;
    this.shelterId = shelterId;
    this.adopted=adopted;
    }

    public Integer getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public Integer getShelterId() { return shelterId; }
    public void setShelterId(Integer shelterId) { this.shelterId = shelterId; }
    public boolean isAdopted() { return false; }
    public void setAdopted(boolean adopt) { this.adopted = adopt; }

    @Override
    public int hashCode() { int hash = 0; hash += (id != null ? id.hashCode() : 0); return hash; }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Pet)) { return false; }
        Pet other = (Pet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) { return false; }
        return true;
    }

    @Override
    public String toString() {
        return "hu.ptee.pawpal.model.Pet[ id=" + id + " ]";
    }
}