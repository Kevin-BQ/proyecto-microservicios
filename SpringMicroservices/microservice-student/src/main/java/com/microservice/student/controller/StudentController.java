package com.microservice.student.controller;

import com.microservice.student.entities.Student;
import com.microservice.student.services.IStudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private IStudentServices studentServices;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student) {
        studentServices.save(student);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(studentServices.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> finById(@PathVariable Long id) {
        Student student = studentServices.findById(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/search-by-course/{idCourse}")
    public ResponseEntity<?> findByIdCourse(@PathVariable Long idCourse){
        return ResponseEntity.ok(studentServices.findAllByCourseId(idCourse));
    }



}
