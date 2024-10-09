package com.microservice.student.services;

import com.microservice.student.entities.Student;

import java.util.List;

public interface IStudentServices {

    List<Student> findAll();

    Student findById(long id);

    void save(Student student);

    List<Student> findAllByCourseId(long courseId);

}
