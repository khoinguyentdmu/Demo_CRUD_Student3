package com.example.repository.impl;

import com.example.exception.StudentNotFoundException;
import com.example.model.Student;
import com.example.repository.IStudentRepository;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//@Repository
public class StudentRepositoryImpl implements IStudentRepository {

	private EntityManagerFactory factory;
	
	private final String PERSISTENCE_UNIT_NAME = "demoJPA";  

	@Override
	public List<Student> findAll() {
		this.factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		List<Student> students = em.createQuery("FROM " + Student.class.getName()).getResultList();
		em.getTransaction().commit();
		
		em.close();
		factory.close();
		return students;
	}

	public Student findById(int id) {
		this.factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		Student student = em.find(Student.class, id);
		em.getTransaction().commit();
		
		em.close();
		factory.close();
		return student;
	}

	@Override
	public void save(Student student) {
		this.factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		em.persist(student);
		em.getTransaction().commit();
		
		em.close();
		factory.close();
	}

	@Override
	public void update(Student student, int id) {
		this.factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		student.setId(id);
		em.merge(student);
		em.getTransaction().commit();
		
		em.close();
		factory.close();
	}

	@Override
	public void delete(int id) {
		this.factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		
		Student student = em.find(Student.class, id);
		if (student == null) throw new StudentNotFoundException(id);
		em.remove(student);
		
		em.getTransaction().commit();
		
		em.close();
		factory.close();
	}

}
