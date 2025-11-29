package org.example.pet.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "adopter")
//@NamedQueries({
//        @NamedQuery(name = "Adopter.findAll", query = "SELECT a FROM Adopter a"),
//        @NamedQuery(name = "Adopter.findById", query = "SELECT a FROM Adopter a WHERE a.id = :id"),
//        @NamedQuery(name = "Adopter.findByName", query = "SELECT a FROM Adopter a WHERE a.name = :name"),
//        @NamedQuery(name = "Adopter.findByEmail", query = "SELECT a FROM Adopter a WHERE a.email = :email"),
//        @NamedQuery(name = "Adopter.findByCity", query = "SELECT a FROM Adopter a WHERE a.city = :city")})
public class Adopter implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adopter")
    private Collection<Adoption> adoptionCollection;

    public Adopter(){
    }

    public Adopter(String name, String email, String phone, String address, String city) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;

    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}
    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}
    public String getCity() {return city;}
    public void setCity(String city) {this.city = city;}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Adopter)) {
            return false;
        }
        Adopter other = (Adopter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.example.pet.model.Adopter[id= " + id + ", name=" + name;
    }

}