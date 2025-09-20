package com.example.MethodologySpringBoot.model;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "student")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "major")
    private String major;

    @Column(name = "email")
    private String email;


}