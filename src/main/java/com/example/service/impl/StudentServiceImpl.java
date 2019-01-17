package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Student;
import com.example.repository.IStudentRepository;
import com.example.service.IStudentService;

//@Service
public class StudentServiceImpl implements IStudentService {

    IStudentRepository studentRepo;

    public IStudentRepository getStudentRepo() {
		return studentRepo;
	}

	public void setStudentRepo(IStudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}

	/**
     * Get all students
     * @return
     */
    public List<Student> getAllStudents() {

        return studentRepo.findAll();
    }

    /**
     * Get student by id
     * @param id
     * @return
     */
    public Student getStudentById(int id) {

        return studentRepo.findById(id);
    }

    /**
     * Create a student
     * @param student
     * @return
     */
    public void createStudent(Student student) {

        studentRepo.save(student);
    }

    /**
     * Update a student
     * @param student
     * @param id
     * @return
     */
    public void updateStudent(Student student, int id) {
 	
    	studentRepo.update(student, id);
    }

    /**
     * Delete a student
     * @param id
     */
    public void deleteStudent(int id){

        studentRepo.delete(id);
    }
}
