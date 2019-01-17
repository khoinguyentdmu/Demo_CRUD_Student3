package com.example.service;

import com.example.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface IStudentService {

    //Get all students
    public List<Student> getAllStudents();

    //Get student by id
    public Student getStudentById(int id);

    //Create a student
    public void createStudent(Student student);

    //Update a student
    public void updateStudent(Student student, int id);

    //Delete a student
    public void deleteStudent(int id);
}
