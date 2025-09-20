package com.example.MethodologySpringBoot.service;

import com.example.MethodologySpringBoot.model.Student;
import com.example.MethodologySpringBoot.repository.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StudentService {
    // CRUD
    @Autowired
    private StudentRepository studentRepository;

    // manage data from database
    @PersistenceContext
    private EntityManager entityManager;

    // business logic
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).get();
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
}
