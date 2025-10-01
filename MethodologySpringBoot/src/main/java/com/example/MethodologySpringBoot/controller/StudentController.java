package com.example.MethodologySpringBoot.controller;

import com.example.MethodologySpringBoot.model.Student;
import com.example.MethodologySpringBoot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    // GET all student
    @GetMapping
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        try {
            Student student = studentService.getStudentById(id);
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @DeleteMapping(path = "{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }

    // UPDATE
    @PutMapping(path = "/edit/{id}")
    public ResponseEntity<Student> updateStudentInfo(@PathVariable Integer id, @RequestBody Student student) {
        // base case
        try {
            Student existingStudent = studentService.getStudentById(id);
            existingStudent.setFirst_name(student.getFirst_name());
            existingStudent.setLast_name(student.getLast_name());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setMajor(student.getMajor());

            studentService.addStudent(existingStudent);

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


//    GET for SPQ
    @GetMapping(path = "/spq")
    public List<Student> getStudentByIdSPQ() {
        return studentService.getAllStudentSPQ();
    }

    // POST for SPQ
    @PostMapping(path = "/spq")
    public void addStudentSPQ(Student student) {
        studentService.addStudentSPQ(student);
    }

    // DELETE for SPQ
    @DeleteMapping(path = "spq/{id}")
    public void deleteStudentSPQ(@PathVariable Integer id) {
        studentService.deleteStudentSPQ(id);
    }

    @PutMapping(path = "updatespq/{id}")
    public void updateStudentSPQ(@PathVariable Integer id, @RequestBody Student student) {
        studentService.editStudentSPQ(id, student);
    }

    // GET for SPQ by id
    @GetMapping(path = "spq/{id}")
    public Optional getStudentByIdSPQ(@PathVariable Integer id) {
        return studentService.getStudentByIdSPQ(id);
    }

    // GET number of student
    @GetMapping(path = "/countstudent")
    public Integer getCountStudent() {
        return studentService.countStudent();
    }

    @GetMapping(path = "lastname")
    public List<Student> findStudentByLastName(@RequestBody String lastName) {
        return studentService.findStudentByLastName(lastName);
    }
}
