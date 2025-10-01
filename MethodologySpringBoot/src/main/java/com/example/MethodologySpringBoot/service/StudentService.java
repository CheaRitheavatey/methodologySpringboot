package com.example.MethodologySpringBoot.service;

import com.example.MethodologySpringBoot.model.Student;
import com.example.MethodologySpringBoot.repository.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Student> getAllStudentSPQ() {
        StoredProcedureQuery spq = entityManager.createStoredProcedureQuery("getStudent");
        return spq.getResultList();
    }

    public void addStudentSPQ(Student student) {
        StoredProcedureQuery spq = entityManager.createStoredProcedureQuery("addStudent");

        // all parameters need to registered (set all the parameter)
        spq.registerStoredProcedureParameter("firstNameIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("lastNameIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("majorIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("emailIN", String.class, ParameterMode.IN);

        // set value for parameter
        spq.setParameter("firstNameIN", student.getFirst_name());
        spq.setParameter("lastNameIN", student.getLast_name());
        spq.setParameter("majorIN", student.getMajor());
        spq.setParameter("emailIN", student.getEmail());

        // then execute
        spq.execute();
    }

    public void deleteStudentSPQ(Integer id) {
        StoredProcedureQuery spq = entityManager.createStoredProcedureQuery("deleteStudent");

        spq.registerStoredProcedureParameter("idIN", Integer.class, ParameterMode.IN);
        spq.setParameter("idIN", id);

        spq.execute();
    }

    public void editStudentSPQ(Integer id, Student student) {
        StoredProcedureQuery spq = entityManager.createStoredProcedureQuery("updateStudent");

        spq.registerStoredProcedureParameter("idIN", Integer.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("firstNameIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("lastNameIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("majorIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("emailIN", String.class, ParameterMode.IN);

        spq.setParameter("idIN", id);
        spq.setParameter("firstNameIN", student.getFirst_name());
        spq.setParameter("lastNameIN", student.getLast_name());
        spq.setParameter("majorIN", student.getMajor());
        spq.setParameter("emailIN", student.getEmail());

        spq.execute();
    }

    public Optional getStudentByIdSPQ(Integer id) {
        StoredProcedureQuery spq = entityManager.createStoredProcedureQuery("getStudentById");

        spq.registerStoredProcedureParameter("idIN", Integer.class, ParameterMode.IN);
        spq.setParameter("idIN", id);

        return spq.getResultStream().findFirst();

    }


}