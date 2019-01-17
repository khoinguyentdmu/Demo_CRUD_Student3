package com.example.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.model.Student;

//@Repository
public interface IStudentRepository {
	
	public List<Student> findAll();

	public Student findById(int id);
	
	public void save(Student student);
	
	public void update(Student student, int id);
	
	public void delete(int id);
}
