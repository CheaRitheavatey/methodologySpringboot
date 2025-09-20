package com.example.MethodologySpringBoot.repository;

import com.example.MethodologySpringBoot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    //JPA = java persistence api
    //ORM = object relational mapping
    // use data from database as native java obj
    // we have access to predefined method by using jpa
    // it provide query language support
}
