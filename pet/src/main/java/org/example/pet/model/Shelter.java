package org.example.pet.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "shelter")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Shelter.findAll", query = "SELECT s FROM Shelter s"),
        @NamedQuery(name = "Shelter.findById", query = "SELECT s FROM Shelter s WHERE s.id = :id"),
        @NamedQuery(name = "Shelter.findByName", query = "SELECT s FROM Shelter s WHERE s.name = :name"),
        @NamedQuery(name = "Shelter.findByLocation", query = "SELECT s FROM Shelter s WHERE s.location = :location"),
        @NamedQuery(name = "Shelter.findByCapacity", query = "SELECT s FROM Shelter s WHERE s.capacity = :capacity"),
        @NamedQuery(name = "Shelter.findByPhone", query = "SELECT s FROM Shelter s WHERE s.phone = :phone"),
        @NamedQuery(name = "Shelter.findByCreationday", query = "SELECT s FROM Shelter s WHERE s.creationday = :creationday")})
public class Shelter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @Size(max = 100)
    @Column(name = "location")
    private String location;
    @Column(name = "capacity")
    private Integer capacity;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creationday")
    @Temporal(TemporalType.DATE)
    private Date creationday;

    public Shelter() {
    }

    public Shelter(Integer id) {
        this.id = id;
    }

    public Shelter(Integer id, Date creationday) {
        this.id = id;
        this.creationday = creationday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreationday() {
        return creationday;
    }

    public void setCreationday(Date creationday) {
        this.creationday = creationday;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shelter)) {
            return false;
        }
        Shelter other = (Shelter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pte.pawpal.hu.model.Shelter[ id=" + id + " ]";
    }

}

